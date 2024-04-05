package com.happinesindex.demo.controller.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String name;

    private String lastName;

    private String dni;

    private String email;

    public UserResponse(String name, String lastName, String dni, String email) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
    }
}
