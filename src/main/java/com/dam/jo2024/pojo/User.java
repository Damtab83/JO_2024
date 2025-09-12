package com.dam.jo2024.pojo;

import com.dam.jo2024.pojo.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @Size(max = 200)
    @Pattern(regexp = "^([A-Z][a-z'-]{1,}\\s?)+$\n", message = "Votre Nom doit contenir des caractères valide")
    private String lastName;

    @NotBlank
    @Size(max = 200)
    @Pattern(regexp = "^([A-Z][a-z'-]{1,}\\s?)+$\n", message = "Votre Prénom doit contenir des caractères valide")
    private String firstName;

    @Email
    @NotBlank
    @Size(max = 200)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n", message = "Votre email doit être un email valide")
    private String email;

    @NotBlank
    @Size(max = 120)
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,}", message = "Le mot de passe doit contenir au moins 8 caractères, une majuscule, une minuscule, un chiffre et un caractère spécial.")
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
