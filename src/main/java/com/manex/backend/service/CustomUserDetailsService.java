package com.manex.backend.service;

import com.manex.backend.entities.TbUsers;
import com.manex.backend.repositories.TbUsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired private TbUsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        TbUsers user = userRepository.findByEMAIL(email);

        String password = user.getPASSWORD() != null ? user.getPASSWORD() : "DUMMY_PASSWORD";

        return new org.springframework.security.core.userdetails.User(
                user.getEMAIL(), password, new ArrayList<>());
    }
}
