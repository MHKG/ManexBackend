package com.manex.backend.service;

import com.manex.backend.entities.TbUsers;
import com.manex.backend.repositories.TbUsersRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired private TbUsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
        TbUsers user = userRepository.findById(Integer.valueOf(user_id)).orElseThrow();

        String password = user.getPASSWORD() != null ? user.getPASSWORD() : "DUMMY_PASSWORD";

        return new User(user.getEMAIL(), password, new ArrayList<>());
    }
}
