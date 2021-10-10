package com.amitnadav.mywarehousemanager.repositories;

import com.amitnadav.mywarehousemanager.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
