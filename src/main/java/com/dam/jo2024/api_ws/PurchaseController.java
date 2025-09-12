package com.dam.jo2024.api_ws;

import com.dam.jo2024.pojo.Purchase;
import com.dam.jo2024.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Displaying CRUD of the Purchases for the API
@RestController
@RequestMapping(ApiRegistration.REST_API + ApiRegistration.REST_PURCHASE
)
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<Object>getAllPurchase() {
        List<Purchase> purchases = purchaseService.getAllPurchases();
        return ResponseEntity.status(HttpStatus.OK).body(purchases);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object>getPurchaseById(@PathVariable Long id) {
        Purchase myPurchase = purchaseService.getPurchaseById(id);
        return myPurchase == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<Object>createPurchase(@RequestBody Purchase myPurchase) {
        purchaseService.createPurchase(myPurchase);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object>deletePurchase(@PathVariable Long id) {
        Boolean isDelete = purchaseService.deletePurchase(id);
        return isDelete ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object>updatePurchaseById(@PathVariable Long id, @RequestBody Purchase newPurchase) {
        purchaseService.updatePurchase(id, newPurchase);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
