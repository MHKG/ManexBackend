package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import java.io.IOException;

public interface TbCtnDAO {
    XscResponse add(HttpServletRequest request, JSONObject payload) throws IOException;

    XscResponse getCartons(JSONObject payload);
}
