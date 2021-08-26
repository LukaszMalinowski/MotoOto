package com.herokuapp.apimotooto.controller;

import com.herokuapp.apimotooto.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/test")
@Slf4j
public class TestController {

    @GetMapping
    public ResponseEntity<String> getAuthenticationMessage(Authentication authentication) {
        User user = (User)authentication.getPrincipal();
        log.debug("User " + user.getUsername() + " got here");
        return ResponseEntity.ok("Hello " + user.getUsername() + "! I can see your email - " + user.getEmail());
    }

}
