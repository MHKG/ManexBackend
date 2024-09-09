package com.manex.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manex.backend.entities.TbUserProfile;
import com.manex.backend.entities.TbUsers;
import com.manex.backend.repositories.TbUserProfileRepository;
import com.manex.backend.repositories.TbUsersRepository;
import com.manex.backend.response.XscResponse;

import jakarta.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthService {

    @Autowired private TbUsersRepository tbUsersRepository;

    @Autowired private TbUserProfileRepository tbUserProfileRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    public XscResponse login(String email, String password) throws JsonProcessingException {
        TbUsers users = tbUsersRepository.findByEMAIL(email);

        XscResponse response = new XscResponse();
        if (passwordEncoder.matches(password, users.getPASSWORD())) {
            response = new XscResponse();

            TbUserProfile userProfile =
                    tbUserProfileRepository.findById(users.getID()).orElseThrow();

            JSONObject data = getJsonObject(userProfile, users);

            response.setXscData(data);
            response.setXscStatus(1);
        } else {
            response.setXscMessage("Username or password is incorrect");
            response.setXscStatus(0);
        }
        return response;
    }

    private static JSONObject getJsonObject(TbUserProfile userProfile, TbUsers users)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(userProfile);
        JSONObject data = new JSONObject(jsonData);
        data.put("F_NAME", userProfile.getF_NAME());
        data.put("M_NAME", userProfile.getM_NAME());
        data.put("L_NAME", userProfile.getL_NAME());
        data.put("ID", userProfile.getUSER_ID());
        data.put("PHONE_MOBILE", userProfile.getPHONE_MOBILE());
        data.put("PHONE_WORK", userProfile.getPHONE_WORK());
        data.put("PHONE_WORK_EXT", userProfile.getPHONE_WORK_EXT());
        data.put("COUNTRY_CODE", userProfile.getCOUNTRY_CODE());
        data.put("PROFILE_IMAGE", userProfile.getPROFILE_IMG());
        data.put("RESET_PASS", users.getRESET_PASS());
        data.put("EMAIL", users.getEMAIL());
        data.put("USER_TYPE", users.getUSER_TYPE());
        return data;
    }
}
