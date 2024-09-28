package com.manex.backend.service;

import com.manex.backend.DAO.TbUserProfileDAO;
import com.manex.backend.entities.TbUserProfile;
import com.manex.backend.repositories.TbUserProfileRepository;
import com.manex.backend.response.XscResponse;

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
import java.util.Objects;

@Service
@Transactional
public class TbUserProfileService implements TbUserProfileDAO {

    @Autowired private TbUserProfileRepository tbUserProfileRepository;

    @Override
    public XscResponse updateUser(HttpServletRequest request, JSONObject payload)
            throws IOException {
        final String uploadDir = "profileImage/";

        int user_id = payload.getInt("USER_ID");

        MultipartFile file = ((StandardMultipartHttpServletRequest) request).getFile("file");

        if (file != null) {
            String fileName =
                    user_id
                            + "."
                            + Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
            Path filePath = Paths.get(uploadDir, fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());
        }

        TbUserProfile tbUserProfile = tbUserProfileRepository.findById(user_id).orElseThrow();
        tbUserProfile.setF_NAME(payload.getString("FIRST_NAME"));
        tbUserProfile.setM_NAME(payload.getString("MIDDLE_NAME"));
        tbUserProfile.setL_NAME(payload.getString("LAST_NAME"));
        tbUserProfileRepository.save(tbUserProfile);

        return new XscResponse(1, "User updated successfully.");
    }
}
