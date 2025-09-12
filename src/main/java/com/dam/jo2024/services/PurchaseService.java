package com.dam.jo2024.services;

import com.dam.jo2024.pojo.Formula;
import com.dam.jo2024.pojo.Purchase;
import com.dam.jo2024.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase>getAllPurchases() {return purchaseRepository.findAll();}

    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Boolean deletePurchase(Long id) {
        Boolean toDelete = purchaseRepository.existsById(id);
        if(toDelete) {
            purchaseRepository.deleteById(id);
        }
        return toDelete;
    }

    public Purchase updatePurchase(Long id, Purchase newPurchase) {
        Purchase oldPurchase = this.getPurchaseById(id);
        if (oldPurchase != null) {
            oldPurchase.setQuantity(newPurchase.getQuantity());
            oldPurchase.setValidation(newPurchase.isValidation());

            oldPurchase.getFormules().clear();
            if (newPurchase.getFormules() != null) {
                newPurchase.getFormules().forEach(oldPurchase::addFormula);
            }

            return purchaseRepository.save(oldPurchase);
        }
        return null;
    }

    public List<Purchase> getPurchasesByUserId(Long userId) {
        return purchaseRepository.findByUserId(userId);
    }

}
