package com.dam.jo2024.ws;

import com.dam.jo2024.pojo.Formula;
import com.dam.jo2024.services.FormulaService;
import com.dam.jo2024.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiRegistration.REST_API + ApiRegistration.REST_TICKET)
public class FormulaController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private FormulaService formulaService;

    @GetMapping
    public ResponseEntity<Object>getAllFormula() {
        List<Formula>formules = formulaService.getFormulaById();
    }
}
