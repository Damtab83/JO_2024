package com.dam.jo2024.ws;

import com.dam.jo2024.api_ws.ApiRegistration;
import com.dam.jo2024.pojo.Formula;
import com.dam.jo2024.services.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Displaying the formulas page and formulas by "id"
@RestController
@RequestMapping(ApiRegistration.REST_FORMULA_BUY)
public class FormulaController {
    @Autowired
    private FormulaService formulaService;

    @GetMapping
    public ResponseEntity<Object>getAllFormulaBuy() {
        List<Formula> formulasBuy = formulaService.getAllFormula();
        return ResponseEntity.status(HttpStatus.OK).body(formulasBuy);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getFormulaBuyById(@PathVariable Long id) {
        Formula myFormulaBuy = formulaService.getFormulaById(id);
        return myFormulaBuy == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(myFormulaBuy);
    }
}
