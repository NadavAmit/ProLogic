package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Product;
import com.amitnadav.mywarehousemanager.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductByIdStep implements IStep {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void execute(Context context) {
        int productId = (int) context.getValue(ContextConstants.PRODUCT_ID);
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isPresent()){
            context.setValue(ContextConstants.PRODUCT,productOptional.get());
        }
    }
}
