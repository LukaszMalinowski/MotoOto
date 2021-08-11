package com.herokuapp.apimotooto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentials {

    @NotBlank(message = "Username is mandatory")
    @NotNull(message = "Username is mandatory")
    private String email;

    @Size (min = 8, max = 128)
    @NotBlank(message = "Password is mandatory")
    private String password;
}
