package com.amitnadav.mywarehousemanager.repositories;

import com.amitnadav.mywarehousemanager.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {

}
