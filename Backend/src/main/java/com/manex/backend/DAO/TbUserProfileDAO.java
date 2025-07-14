package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import java.io.IOException;

public interface TbUserProfileDAO {
    XscResponse updateUser(HttpServletRequest request, JSONObject payload) throws IOException;

    XscResponse getUserProfileDetails(String token);
}
