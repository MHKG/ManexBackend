package com.manex.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.manex.backend.entities.TbCompanyUser;
import com.manex.backend.entities.TbUsers;
import com.manex.backend.repositories.TbCompanyUserRepository;
import com.manex.backend.repositories.TbUserProfileRepository;
import com.manex.backend.repositories.TbUsersRepository;
import com.manex.backend.response.XscResponse;
import com.manex.backend.util.JwtUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import org.hibernate.query.sql.internal.NativeQueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional
public class AuthService {

    @Autowired private TbUsersRepository tbUsersRepository;

    @Autowired private TbUserProfileRepository tbUserProfileRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @Autowired private JwtUtil jwtUtil;

    @Autowired private TbCompanyUserRepository tbCompanyUserRepository;

    @Autowired private Environment environment;

    @PersistenceContext private EntityManager entityManager;

    private final JdbcTemplate jdbcTemplate;

    public AuthService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public XscResponse login(String email, String password) {
        TbUsers users = tbUsersRepository.findByEMAIL(email);

        XscResponse response = new XscResponse();
        if (passwordEncoder.matches(password, users.getPASSWORD())) {
            String token = jwtUtil.generateToken(users);
            response = new XscResponse();

            List<Map<String, Object>> list = getLoginDetails(users.getID());

            List<TbCompanyUser> tbCompanyUserList =
                    tbCompanyUserRepository.findAllByUSER_ID(users.getID());

            JsonObject data = getJsonObject(list, users, token, tbCompanyUserList);

            JsonNode jsonNode = convertGsonToJackson(data);

            response.setXscData(jsonNode);
            response.setXscStatus(1);
        } else {
            response.setXscMessage("Username or password is incorrect");
            response.setXscStatus(0);
        }
        return response;
    }

    private List<Map<String, Object>> getLoginDetails(Integer id) {
        Query query =
                entityManager.createNativeQuery(environment.getProperty("getDetailsAfterLogin"));
        String sql = ((NativeQueryImpl) query).getQueryString();

        return jdbcTemplate.query(
                sql,
                new Object[] {id},
                (ResultSet rs, int rowNum) -> {
                    Map<String, Object> row = new HashMap<>();
                    int columnCount = rs.getMetaData().getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        row.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
                    }
                    return row;
                });
    }

    private JsonNode convertGsonToJackson(JsonObject gsonObject) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonElement jsonElement = JsonParser.parseString(gsonObject.toString());
            return mapper.readTree(jsonElement.toString());
        } catch (Exception e) {
            throw new RuntimeException("Error converting Gson JsonObject to Jackson JsonNode", e);
        }
    }

    private static JsonObject getJsonObject(
            List<Map<String, Object>> userProfile,
            TbUsers users,
            String token,
            List<TbCompanyUser> tbCompanyUserList) {
        JsonObject data = new JsonObject();

        if (userProfile != null && !userProfile.isEmpty()) {
            Map<String, Object> profile = userProfile.get(0);

            for (Map.Entry<String, Object> entry : profile.entrySet()) {
                if (!(Objects.equals(entry.getKey(), "AC_C_USER_ID")
                        || Objects.equals(entry.getKey(), "APP_CLIENT_ID")
                        || Objects.equals(entry.getKey(), "COMPANY_ID"))) {
                    if (entry.getValue() != null) {
                        data.addProperty(entry.getKey(), entry.getValue().toString());
                    } else {
                        data.addProperty(entry.getKey(), "null");
                    }
                }
            }

            JsonArray clientDetailsArray = new JsonArray();
            for (Map<String, Object> user : userProfile) {
                JsonObject jsonObject1 = new JsonObject();
                jsonObject1.addProperty("APP_CLIENT_ID", user.get("APP_CLIENT_ID").toString());
                jsonObject1.addProperty("CLIENT_NAME", user.get("NAME").toString());
                JsonArray companyUserArray = new JsonArray();
                for (TbCompanyUser tbCompanyUser : tbCompanyUserList) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("AC_C_USER_ID", tbCompanyUser.getAC_C_USER_ID());
                    jsonObject.addProperty("COMPANY_ID", tbCompanyUser.getCOMPANY_ID());
                    jsonObject.addProperty("COMPANY_NAME", user.get("NAME").toString());
                    companyUserArray.add(jsonObject);
                }
                jsonObject1.add("COMPANIES", companyUserArray);
                clientDetailsArray.add(jsonObject1);
            }
            data.add("APP_CLIENT_DETAILS", clientDetailsArray);
        }

        data.addProperty("RESET_PASS", users.getRESET_PASS());
        data.addProperty("EMAIL", users.getEMAIL());
        data.addProperty("USER_TYPE", users.getUSER_TYPE());
        data.addProperty("TOKEN", token);
        //		data.addProperty(userProfile.get(0));

        return data;
    }
}
