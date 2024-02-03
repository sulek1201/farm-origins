package com.sulek.farmorigins.controller;

import com.sulek.farmorigins.dto.LoginRequest;
import com.sulek.farmorigins.dto.RegistrationRequest;
import com.sulek.farmorigins.dto.TokenResponse;
import com.sulek.farmorigins.dto.UserSummaryResponse;
import com.sulek.farmorigins.entity.User;
import com.sulek.farmorigins.security.JwtTokenUtil;
import com.sulek.farmorigins.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/account")
@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) throws AuthenticationException {
        User user = userService.findByEmail(request.getEmail());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), request.getPassword()));
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new TokenResponse(user.getEmail(), token, user.getUserRole(), jwtTokenUtil.getExpirationDateFromToken(token), user.getId(), user.getFirstName().concat(" ").concat(user.getLastName())));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Boolean> register(@RequestBody RegistrationRequest registrationRequest) throws AuthenticationException {
        Boolean response = userService.register(registrationRequest);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/user-summary", method = RequestMethod.POST)
    public ResponseEntity<UserSummaryResponse> userSummary(@RequestHeader("Authorization") String jwtToken) throws AuthenticationException {
        User user = getUser(jwtToken);
        return ResponseEntity.ok(new UserSummaryResponse(user.getEmail(), user.getUserRole(), user.getId(),user.getFirstName().concat(" ").concat(user.getLastName())));
    }

    private User getUser(String jwtToken) {
        String email = JwtTokenUtil.parseUserEmailFromJwt(jwtToken);
        return userService.findByEmail(email);
    }
}
