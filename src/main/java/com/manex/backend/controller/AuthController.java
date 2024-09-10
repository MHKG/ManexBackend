package com.manex.backend.controller;

import com.manex.backend.DAO.AuthDAO;
import com.manex.backend.entities.TbUsers;
import com.manex.backend.response.XscResponse;
import com.manex.backend.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired private AuthDAO authDAO;

    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/login")
    private XscResponse login(
            @RequestParam("email") String email, @RequestParam("password") String password) {
        return authDAO.login(email, password);
    }

    @GetMapping("/verifyToken")
    public boolean verifyToken(@RequestHeader("Authorization") String token) {
        return !jwtUtil.isTokenExpired(token.split(" ")[1]);
    }

    @PostMapping("/updatePassword")
    public TbUsers updatePassword(
            @RequestParam("password") String password,
            @RequestHeader("Authorization") String token) {
        return authDAO.updatePassword(password, token.substring(7));
    }
}
