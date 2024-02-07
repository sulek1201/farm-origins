package com.sulek.farmorigins.controller;

import com.sulek.farmorigins.dto.*;
import com.sulek.farmorigins.entity.User;
import com.sulek.farmorigins.security.JwtTokenUtil;
import com.sulek.farmorigins.service.StoreServiceImpl;
import com.sulek.farmorigins.service.UserService;
import com.sulek.farmorigins.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/store")
@RestController
@CrossOrigin
public class StoreController {

   @Autowired
   private UserServiceImpl userService;

   @Autowired
   private StoreServiceImpl storeService;

    @RequestMapping(value = "/create-store", method = RequestMethod.POST)
    public ResponseEntity<Boolean> createStore(@RequestBody CreateStoreRequest createStoreRequest, @RequestHeader("Authorization") String jwtToken) {
        User user = getUser(jwtToken);
        return ResponseEntity.ok(storeService.createStore(createStoreRequest, user));
    }

    @RequestMapping(value = "/update-store", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateStore(@RequestBody UpdateStoreRequest updateStoreRequest, @RequestHeader("Authorization") String jwtToken) {
        return ResponseEntity.ok(storeService.updateStore(updateStoreRequest));
    }

    @RequestMapping(value = "/update-store/{storeId}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteStore(@PathVariable("storeId") Long storeId, @RequestHeader("Authorization") String jwtToken) {
        return ResponseEntity.ok(storeService.deleteStore(storeId));
    }

    @RequestMapping(value = "/get-store-cards", method = RequestMethod.GET)
    public ResponseEntity<List<StoreCardResponseByUser>> getStoreCards(@RequestHeader("Authorization") String jwtToken) {
        User user = getUser(jwtToken);
        return ResponseEntity.ok(storeService.getStoreCards(user));
    }

    @RequestMapping(value = "/get-store/{storeId}", method = RequestMethod.GET)
    public ResponseEntity<StoreResponse> getStore(@PathVariable("storeId") Long storeId, @RequestHeader("Authorization") String jwtToken) {
        return ResponseEntity.ok(storeService.getStore(storeId));
    }


    private User getUser(String jwtToken) {
        String email = JwtTokenUtil.parseUserEmailFromJwt(jwtToken);
        return userService.findByEmail(email);
    }
}
