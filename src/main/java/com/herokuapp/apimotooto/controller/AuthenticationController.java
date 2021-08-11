package com.herokuapp.apimotooto.controller;

import com.herokuapp.apimotooto.dto.UserCredentials;
import com.herokuapp.apimotooto.dto.UserDto;
import com.herokuapp.apimotooto.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping ("/api/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping ("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserCredentials userCredentials) {
        String accessToken = authenticationService.getAccessToken(userCredentials);

        return ResponseEntity.ok(accessToken);
    }

    @PostMapping ("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserDto userDto) {
        authenticationService.registerUser(userDto);

        return login(new UserCredentials(userDto.getEmail(), userDto.getPassword()));
    }

}
