package com.amitnadav.mywarehousemanager.controllers;

import com.amitnadav.mywarehousemanager.models.Customer;
import com.amitnadav.mywarehousemanager.repositories.CustomerRepository;
import com.amitnadav.mywarehousemanager.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository repository;

    @GetMapping({"/",""})
    public List<Customer> getAllCustomers(){

        return customerService.getAllCustomers();
    }

    @RequestMapping(method = RequestMethod.POST,value = {"/",""})
    @PostMapping({"","/"})
    public void addNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomerById(@PathVariable int customerId){
        customerService.deleteCustomerById(customerId);
    }

}
