package com.example.basics.model.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {
    private String token;
    private String type;
}
