package com.example.basics.auth.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDTO {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
