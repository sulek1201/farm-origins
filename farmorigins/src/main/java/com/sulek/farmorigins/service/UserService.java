package com.sulek.farmorigins.service;





import com.sulek.farmorigins.dto.RegistrationRequest;
import com.sulek.farmorigins.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Boolean register(RegistrationRequest registrationRequest);

    User findByEmail(String userName);


}
