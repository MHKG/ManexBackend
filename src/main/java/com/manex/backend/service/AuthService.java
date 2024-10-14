package com.manex.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.AuthDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.entities.TbCompanyUser;
import com.manex.backend.entities.TbMm;
import com.manex.backend.entities.TbUsers;
import com.manex.backend.repositories.TbCompanyUserRepository;
import com.manex.backend.repositories.TbMmRepository;
import com.manex.backend.repositories.TbUsersRepository;
import com.manex.backend.response.XscResponse;
import com.manex.backend.util.JwtUtil;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AuthService implements AuthDAO {

    @Autowired private TbUsersRepository tbUsersRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @Autowired private JwtUtil jwtUtil;

    @Autowired private TbCompanyUserRepository tbCompanyUserRepository;

    @Autowired private TbMmRepository tbMmRepository;

    @Override
    public XscResponse login(String email, String password) {
        TbUsers users = tbUsersRepository.findByEMAIL(email);

        XscResponse response = new XscResponse();
        if (passwordEncoder.matches(password, users.getPASSWORD())) {
            String token = jwtUtil.generateToken(users);
            response = new XscResponse();

            List<Map<String, Object>> list =
                    tbCompanyUserRepository.findAllDataByUserId(users.getID());

            List<TbCompanyUser> tbCompanyUserList =
                    tbCompanyUserRepository.findAllByUSER_ID(users.getID());

            JsonObject data = new JsonObject();

            if (list != null && !list.isEmpty()) {
                Map<String, Object> profile = list.get(0);

                TbMm tbMm = tbMmRepository.findById((int) profile.get("PROFILE_IMG")).orElseThrow();

                data.addProperty("F_NAME", (String) profile.get("F_NAME"));
                data.addProperty("M_NAME", (String) profile.get("M_NAME"));
                data.addProperty("L_NAME", (String) profile.get("L_NAME"));
                data.addProperty("PROFILE_IMAGE", tbMm.getMM_FILE_NAME());

                JsonArray clientDetailsArray = new JsonArray();
                for (Map<String, Object> user : list) {
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

            data.addProperty("ID", users.getID());
            data.addProperty("RESET_PASS", users.getRESET_PASS());
            data.addProperty("EMAIL", users.getEMAIL());
            data.addProperty("USER_TYPE", users.getUSER_TYPE());
            data.addProperty("TOKEN", token);

            JsonNode jsonNode = GenericMethods.convertGsonToJackson(data);

            response.setXscData(jsonNode);
            response.setXscMessage("Login Success");
            response.setXscStatus(1);
        } else {
            response.setXscMessage("Username or password is incorrect");
            response.setXscStatus(0);
        }
        return response;
    }

    @Override
    public TbUsers updatePassword(String password, String token) {
        String user_id = jwtUtil.extractUserId(token);
        TbUsers user = tbUsersRepository.findById(Integer.valueOf(user_id)).orElseThrow();
        user.setPASSWORD(passwordEncoder.encode(password));
        return tbUsersRepository.save(user);
    }
}
