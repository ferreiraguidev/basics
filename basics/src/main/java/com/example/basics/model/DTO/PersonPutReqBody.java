package com.example.basics.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonPutReqBody {
    private String document;
    private String name;
    private String genero;
    private String age;
    private String email;
}
