package com.example.basics.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Setter
@Getter
@Entity
public class Users {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Basic(optional = false)
    @Column(unique = true)
    private String login;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;
    private boolean admin = false;
    private boolean active = true;
}
