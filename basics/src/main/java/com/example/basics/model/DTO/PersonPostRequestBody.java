package com.example.basics.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonPostRequestBody {

    private String document; // not autogenerated
    private String name;
    private String genero;
    private String age;
    private String email;
}
