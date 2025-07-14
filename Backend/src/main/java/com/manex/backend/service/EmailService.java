package com.manex.backend.service;

import com.manex.backend.DAO.EmailDAO;
import com.manex.backend.entities.TbUsers;
import com.manex.backend.repositories.TbUsersRepository;
import com.manex.backend.util.JwtUtil;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmailService implements EmailDAO {

    @Autowired private JavaMailSender javaMailSender;

    @Autowired private TbUsersRepository tbUsersRepository;

    @Autowired private JwtUtil jwtUtil;

    @Override
    public void sendEmail(String email) {
        TbUsers user = tbUsersRepository.findByEMAIL(email);
        if (user != null) {
            String jwtToken = jwtUtil.generateTokenForPasswordReset(user.getID().toString());
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setFrom("mehulkedia30@gmail.com");
            message.setSubject("Reset Link");
            message.setText(
                    "Password reset link for email-id: "
                            + email
                            + " is http://localhost:3000/change-password?token="
                            + jwtToken);
            javaMailSender.send(message);
        }
    }
}
