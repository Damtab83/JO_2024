package com.dam.jo2024.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Formula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String formulaName;

    @NotNull
    private int FormulaPrice;

    @NotNull
    private int ticketNumber;

    @NotBlank
    @Lob
    private String description;

    @OneToMany(mappedBy = "formula", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(min = 1, max = 4)
    private List<Ticket> tickets = new ArrayList<>();

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setFormula(null);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        ticket.setFormula(null);
    }

    @Override
    public String toString() {
        return "Formula{" +
                "Nom Formule='" + formulaName + '\'' +
                ", Prix Formule=" + FormulaPrice +
                ", Nombre Ticket=" + ticketNumber +
                ", Description='" + description + '\'' +
                '}';
    }
}
