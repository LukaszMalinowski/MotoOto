package com.herokuapp.apimotooto.service;

import com.herokuapp.apimotooto.dto.UserCredentials;
import com.herokuapp.apimotooto.dto.UserDto;
import com.herokuapp.apimotooto.exception.UserAlreadyExistsException;
import com.herokuapp.apimotooto.model.User;
import com.herokuapp.apimotooto.repository.UserRepository;
import com.herokuapp.apimotooto.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public String getAccessToken(UserCredentials userCredentials) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userCredentials.getEmail(), userCredentials.getPassword()
                ));

        User user = (User)authentication.getPrincipal();
        log.info(user.getEmail() + " logged in");
        return jwtUtil.createToken(user);
    }

    @Transactional
    public void registerUser(UserDto userDto) {
        if (userExists(userDto.getEmail())) {
            throw new UserAlreadyExistsException(userDto.getEmail());
        }

        User user = new User(null,
                             userDto.getUsername(),
                             userDto.getEmail(),
                             passwordEncoder.encode(userDto.getPassword()),
                             Collections.emptySet());

        userRepository.save(user);
        log.info("User with email " + user.getEmail() + " registered");
    }

    private boolean userExists(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }

}
