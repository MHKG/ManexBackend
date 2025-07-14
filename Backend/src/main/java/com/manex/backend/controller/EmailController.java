package com.manex.backend.controller;

import com.manex.backend.DAO.EmailDAO;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email_controller")
public class EmailController {

    @Autowired private EmailDAO emailDAO;

    @PostMapping("/sendEmail")
    public XscResponse sendEmail(@RequestParam("payload") JSONObject payload) {
        emailDAO.sendEmail(payload.getString("EMAIL"));
        XscResponse response = new XscResponse();
        response.setXscMessage("Password reset link sent to your email.");
        response.setXscStatus(1);
        return response;
    }
}
