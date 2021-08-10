package com.herokuapp.apimotooto.controller;

import com.herokuapp.apimotooto.dto.UserCredentials;
import com.herokuapp.apimotooto.model.User;
import com.herokuapp.apimotooto.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping ("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserCredentials userCredentials) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userCredentials.getEmail(), userCredentials.getPassword()
                    ));

            User user = (User)authentication.getPrincipal();
            log.info(user.getEmail() + " logged in");
            return ResponseEntity.ok(jwtUtil.createToken(user));
        }
        catch (BadCredentialsException exception) {
            log.info(userCredentials.getEmail() + " entered bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
