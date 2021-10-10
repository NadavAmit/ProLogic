package com.amitnadav.mywarehousemanager.services;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Product;
import com.amitnadav.mywarehousemanager.models.User;
import com.amitnadav.mywarehousemanager.steps.AddNewProductStep;
import com.amitnadav.mywarehousemanager.steps.GetAllProductsStep;
import com.amitnadav.mywarehousemanager.steps.GetProductByIdStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.CompositeName;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    GetAllProductsStep getAllProductsStep;

    @Autowired
    GetProductByIdStep getProductByIdStep;

    @Autowired
    AddNewProductStep addNewProductStep;

    @Autowired
    public List<Product> getAllProducts(){
        Context context = new Context();
        getAllProductsStep.execute(context);
        List<Product> productList = (List<Product>) context.getValue(ContextConstants.PRODUCTS_LIST);
        return productList;

    }

    public Product getProductById(int productId) {
        Context context = new Context();
        context.setValue(ContextConstants.PRODUCT_ID,productId);
        getProductByIdStep.execute(context);
        Product product = (Product) context.getValue(ContextConstants.PRODUCT);
        return product;
    }

    public void addNewProduct(Product product) {
        Context context = new Context();
        context.setValue(ContextConstants.PRODUCT,product);
        addNewProductStep.execute(context);

    }

}
