package com.dam.jo2024.ws;

import com.dam.jo2024.pojo.Formula;
import com.dam.jo2024.services.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiRegistration.REST_API + ApiRegistration.REST_FORMULA)
public class FormulaController {

    @Autowired
    private FormulaService formulaService;

    @GetMapping
    public ResponseEntity<Object>getAllFormula() {
        List<Formula>formulas = formulaService.getAllFormula();
        return ResponseEntity.status(HttpStatus.OK).body(formulas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object>getFormulaById(@PathVariable Long id) {
        Formula myFormula = formulaService.getFormulaById(id);
        return myFormula == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(myFormula);
    }

    @PostMapping
    public ResponseEntity<Object>createFormula(@RequestBody Formula myFormula) {
        formulaService.createFormula(myFormula.getTickets(), myFormula.getFormulaName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object>deleteFormulaById(@PathVariable Long id) {
        Boolean isDelete = formulaService.deleteFormula(id);
        return isDelete ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object>updateFormulaById(@PathVariable Long id, @RequestBody Formula newFormula) {
        formulaService.updateFormula(id, newFormula);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
