package com.manex.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.manex.backend.response.XscResponse;
import com.manex.backend.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired private AuthService authService;

    @PostMapping("login")
    private XscResponse login(
            @RequestParam("email") String email, @RequestParam("password") String password) throws JsonProcessingException {
        return authService.login(email, password);
    }
}
