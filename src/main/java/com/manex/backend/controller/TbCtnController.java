package com.manex.backend.controller;

import com.manex.backend.DAO.TbCtnDAO;
import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/carton_controller")
public class TbCtnController {

    @Autowired private TbCtnDAO tbCtnDAO;

    @PostMapping("/addCarton")
    private XscResponse addCarton(
            HttpServletRequest request, @RequestParam("payload") JSONObject payload)
            throws IOException {
        return tbCtnDAO.add(request, payload);
    }

    @PostMapping("/getCartons")
    private XscResponse getCartons(@RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID) {
        return tbCtnDAO.getCartons(APP_CLIENT_ID);
    }
}
