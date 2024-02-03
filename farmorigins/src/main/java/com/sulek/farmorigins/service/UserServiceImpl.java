package com.sulek.farmorigins.service;


import com.sulek.farmorigins.dto.RegistrationRequest;
import com.sulek.farmorigins.entity.User;
import com.sulek.farmorigins.exception.CustomerNotFoundException;
import com.sulek.farmorigins.exception.DuplicateKeyValueException;
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
                    .password(bCryptPasswordEncoder.encode(registrationRequest.getPassword()))
                    .firstName(registrationRequest.getFirstName())
                    .lastName(registrationRequest.getLastName())
                    .phoneNumber(registrationRequest.getPhoneNumber())
                    .userRole(registrationRequest.getUserRole())
                    .emailActivision(false)
                    .build();
            user.setStatus(true);
            user.setCreatedAt(new Date());
            userRepository.save(user);
            return Boolean.TRUE;
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateKeyValueException(ex.getMessage());
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new CustomerNotFoundException("user not found");
        }
        return user;
    }
}
