package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Product;
import com.amitnadav.mywarehousemanager.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsStep implements IStep {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void execute(Context context) {
        List<Product> productList = (List<Product>) productRepository.findAll();
        context.setValue(ContextConstants.PRODUCTS_LIST,productList);
    }
}
