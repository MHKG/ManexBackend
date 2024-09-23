package com.manex.backend.controller;

import com.manex.backend.DAO.TbUserProfileDAO;
import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/users_controller")
public class TbUserProfileController {

    @Autowired private TbUserProfileDAO tbUserProfileDAO;

    @PostMapping("/updateUser")
    private XscResponse updateUser(
            HttpServletRequest request, @RequestParam("payload") JSONObject payload) throws IOException {
        return tbUserProfileDAO.updateUser(request, payload);
    }
}
