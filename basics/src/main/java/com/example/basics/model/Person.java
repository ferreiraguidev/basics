package com.example.basics.model;


import lombok.*;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Setter
@Getter
@Entity
public class Person {

    @Id
    private String document;

    private String name;

    private String genero;

    private String age;

    @Email
    private String email;

}
