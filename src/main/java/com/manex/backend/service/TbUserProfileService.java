package com.manex.backend.service;

import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbUserProfileDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.entities.TbMm;
import com.manex.backend.entities.TbUserProfile;
import com.manex.backend.entities.TbUsers;
import com.manex.backend.repositories.TbMmRepository;
import com.manex.backend.repositories.TbUserProfileRepository;
import com.manex.backend.repositories.TbUsersRepository;
import com.manex.backend.response.XscResponse;
import com.manex.backend.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional
public class TbUserProfileService implements TbUserProfileDAO {

    @Autowired private TbUserProfileRepository tbUserProfileRepository;

    @Autowired private TbUsersRepository tbUsersRepository;

    @Autowired private JwtUtil jwtUtil;

    @Autowired private TbMmRepository tbMmRepository;

    @Override
    public XscResponse updateUser(HttpServletRequest request, JSONObject payload)
            throws IOException {
        final String uploadDir = "profileImage/";

        TbUsers tbUsers = tbUsersRepository.findByEMAIL(payload.getString("EMAIL"));

        int user_id = tbUsers.getID();

        TbUserProfile tbUserProfile = tbUserProfileRepository.findById(user_id).orElseThrow();

        TbMm tbMm = tbMmRepository.findById(tbUserProfile.getPROFILE_IMG()).orElseThrow();

        MultipartFile file = ((StandardMultipartHttpServletRequest) request).getFile("file");

        if (file != null) {
            String fileName = user_id + "." + tbMm.getMM_FILE_NAME().split("\\.")[1];
            Path filePath = Paths.get(uploadDir, fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());
        }

        tbUserProfile.setF_NAME(payload.getString("F_NAME"));
        tbUserProfile.setM_NAME(payload.getString("M_NAME"));
        tbUserProfile.setL_NAME(payload.getString("L_NAME"));
        tbUserProfileRepository.save(tbUserProfile);

        if (file != null) {
            XscResponse response = new XscResponse();
            response.setXscData(GenericMethods.convertGsonToJackson(new JsonObject()));
            response.setXscMessage("Success.");
            response.setXscStatus(1);

            return response;
        } else {
            return new XscResponse(1, "User updated successfully.");
        }
    }

    @Override
    public XscResponse getUserProfileDetails(String token) {
        String user_id = jwtUtil.extractUserId(token);

        TbUserProfile tbUserProfile =
                tbUserProfileRepository.findById(Integer.valueOf(user_id)).orElseThrow();

        TbUsers tbUsers = tbUsersRepository.findById(Integer.valueOf(user_id)).orElseThrow();

        TbMm tbMm = tbMmRepository.findById(tbUserProfile.getPROFILE_IMG()).orElseThrow();

        JsonObject data = new JsonObject();
        data.addProperty("F_NAME", tbUserProfile.getF_NAME());
        data.addProperty("M_NAME", tbUserProfile.getM_NAME());
        data.addProperty("L_NAME", tbUserProfile.getL_NAME());
        data.addProperty("EMAIL", tbUsers.getEMAIL());
        data.addProperty("PROFILE_IMG", tbMm.getMM_FILE_NAME());

        XscResponse response = new XscResponse();

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("User profile details fetched.");
        response.setXscStatus(1);
        return response;
    }
}
