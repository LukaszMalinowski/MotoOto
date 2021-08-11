package com.herokuapp.apimotooto.service;

import com.herokuapp.apimotooto.dto.UserDto;
import com.herokuapp.apimotooto.exception.UserAlreadyExistsException;
import com.herokuapp.apimotooto.model.User;
import com.herokuapp.apimotooto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public void registerUser(UserDto userDto) {
        if (userExists(userDto.getEmail())) {
            throw new UserAlreadyExistsException(userDto.getEmail());
        }

        User user = new User(null,
                             userDto.getUsername(),
                             userDto.getEmail(),
                             passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);
        log.debug("User with email " + user.getEmail() + " registered");
    }

    private boolean userExists(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }

}
