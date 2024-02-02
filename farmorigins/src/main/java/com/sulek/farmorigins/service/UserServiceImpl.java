package com.sulek.farmorigins.service;


import com.sulek.farmorigins.dto.RegistrationRequest;
import com.sulek.farmorigins.entity.User;
import com.sulek.farmorigins.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component("UserServiceImpl")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Boolean register(RegistrationRequest registrationRequest) {
        try {
            User user = User.builder()
                    .email(registrationRequest.getEmail())
                    .nameSurname(registrationRequest.getNameSurname())
                    .password(bCryptPasswordEncoder.encode(registrationRequest.getPassword()))
                    .username(registrationRequest.getUsername())
                    .address(registrationRequest.getAddress())
                    .emailActivision(false)
                    .build();
            user.setStatus(true);
            user.setCreatedAt(new Date());
            userRepository.save(user);
            return Boolean.TRUE;
        } catch (DataIntegrityViolationException ex) {
            return null;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public User findByUserName(String userName) {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
        }
        return user;
    }
}
