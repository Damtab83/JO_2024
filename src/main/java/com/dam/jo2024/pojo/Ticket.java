package com.dam.jo2024.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCreation;

    private String ticketKey;

    private String qrCode;

    @ManyToOne
    @JoinColumn(name = "formula_id")
    private Formula formula;
}
