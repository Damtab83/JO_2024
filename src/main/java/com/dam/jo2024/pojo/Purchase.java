package com.dam.jo2024.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int quantity;

    private boolean validation = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Formula> formules = new ArrayList<>();

    public void addFormula(Formula formula) {
        formules.add(formula);
        formula.setPurchase(this);
    }

    public void removeFormula(Formula formula) {
        formules.remove(formula);
        formula.setPurchase(null);
    }


}
