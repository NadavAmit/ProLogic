package com.amitnadav.mywarehousemanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationException implements SubmissionStatus {
    private int exceptionId;
    private String exception;

    public void setOutOfStockExcpetion(Product product, int stock, int desiredStock){
        exception = "The Product" + product.getProductName() + "(" + product.getProductId() + ") has "
                + stock + "units in stock but you ordered " + desiredStock + " units." +
                " Please change quantity or load more in stock";
    }

}
