package com.dam.jo2024.services;

import com.dam.jo2024.pojo.Formula;
import com.dam.jo2024.pojo.Ticket;
import com.dam.jo2024.repositories.FormulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormulaService {

    @Autowired
    private FormulaRepository formulaRepository;

    public List<Formula>getAllFormula() {return formulaRepository.findAll();}
    public Formula getFormulaById(Long id) {
        return formulaRepository.findById(id).orElse(null);
    }

    public Formula createFormula(List<Ticket> tickets, String name) {

        int formulaSize = tickets.size();

        if(formulaSize != 1 && formulaSize != 2 && formulaSize != 4) {
            throw new IllegalArgumentException("Une formule doit contenir 1, 2, ou 4 tickets");
        }

        Formula formula = new Formula();
        formula.setFormulaName(name);

        for(Ticket ticket: tickets) {
            formula.addTicket(ticket);
        }
        return formulaRepository.save(formula);
    }
}
