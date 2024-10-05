package com.manex.backend.controller;

import com.manex.backend.DAO.AuthDAO;
import com.manex.backend.entities.TbUsers;
import com.manex.backend.response.XscResponse;
import com.manex.backend.util.JwtUtil;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private AuthDAO authDAO;

    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/login")
    private XscResponse login(@RequestParam("payload") JSONObject payload) {
        return authDAO.login(payload.getString("EMAIL"), payload.getString("PASSWORD"));
    }

    @GetMapping("/verifyToken")
    public XscResponse verifyToken(@RequestHeader("Authorization") String token) {
        boolean isValid = !jwtUtil.isTokenExpired(token.split(" ")[1]);

        XscResponse response = new XscResponse();
        if (isValid) {
            response.setXscMessage("Token is valid.");
            response.setXscStatus(1);
        } else {
            response.setXscMessage("Token is invalid.");
            response.setXscStatus(0);
        }
        return response;
    }

    @PostMapping("/updatePassword")
    public XscResponse updatePassword(
            @RequestParam("payload") JSONObject payload,
            @RequestHeader("Authorization") String token) {
        TbUsers users = authDAO.updatePassword(payload.getString("PASSWORD"), token.substring(7));

        XscResponse response = new XscResponse();

        if (users != null) {
            response.setXscMessage("Password has been changed successfully.");
            response.setXscStatus(1);
        } else {
            response.setXscMessage("Password not changed.");
            response.setXscStatus(0);
        }
        return response;
    }
}
