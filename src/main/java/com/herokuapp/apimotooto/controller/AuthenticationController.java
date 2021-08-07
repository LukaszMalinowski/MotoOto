package com.herokuapp.apimotooto.controller;

import com.herokuapp.apimotooto.dto.UserCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping ("/api/auth")
public class AuthenticationController {

    private final String testToken = "uifkrywuiyfs1243sds3453SDbnf";

    //TODO add proper jwt authentication
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserCredentials userCredentials) {
        if (!(userCredentials.getUsername().equals("test") && userCredentials.getPassword().equals("qwerty123"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(testToken);
    }

}
