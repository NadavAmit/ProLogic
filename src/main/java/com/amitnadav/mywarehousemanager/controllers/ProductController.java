package com.amitnadav.mywarehousemanager.controllers;

import com.amitnadav.mywarehousemanager.models.Product;
import com.amitnadav.mywarehousemanager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //getAll
    @GetMapping({"","/"})
    public List<Product> getAllProducts(){
       return productService.getAllProducts();
    }

    //getById
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable int productId){
        return productService.getProductById(productId);
    }

    @PostMapping({"","/"})
    public void addNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }


    
    //update

    //deleteById
}
