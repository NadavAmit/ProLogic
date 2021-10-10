package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Customer;
import com.amitnadav.mywarehousemanager.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNewCustomerStep implements IStep {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void execute(Context context) {
        Customer newCustomer = (Customer) context.getValue(ContextConstants.CUSTOMER);
        customerRepository.save(newCustomer);
    }
}
