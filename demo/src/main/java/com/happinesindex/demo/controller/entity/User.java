package com.happinesindex.demo.controller.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "user",
    uniqueConstraints = {
        @UniqueConstraint(
                columnNames = "email"
        ),
        @UniqueConstraint(
                columnNames = "dni"
        )
    }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @Size(max = 10)
    @NotNull
    @Column(name = "dni",
            unique = true)
    private String dni;

    @NotNull
    @Column(name = "email",
            unique = true)
    private String email;


}
