package com.example.basics.model.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequestDTO {
    private String login;
    private String password;
}
