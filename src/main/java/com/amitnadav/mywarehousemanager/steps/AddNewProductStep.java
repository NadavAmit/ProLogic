package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Product;
import com.amitnadav.mywarehousemanager.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNewProductStep implements IStep{

    @Autowired
    ProductRepository productRepository;


    @Override
    public void execute(Context context) {
        Product newProduct = (Product) context.getValue(ContextConstants.PRODUCT);
        productRepository.save(newProduct);
    }
}
