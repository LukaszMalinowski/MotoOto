package com.herokuapp.apimotooto.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @NotBlank (message = "Username is mandatory")
    private String username;

    @Email (message = "Email not valid")
    @NotBlank (message = "Username is mandatory")
    private String email;

    @Size (min = 8, max = 128)
    @NotBlank (message = "Password is mandatory")
    private String password;
}
