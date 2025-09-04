package com.dam.jo2024.pojo;

import com.dam.jo2024.pojo.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Min(value = 12)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String userKey;

    public User(Long id, String lastName, String firstName, String email, String password) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "Nom='" + lastName + '\'' +
                ", Prénom='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
