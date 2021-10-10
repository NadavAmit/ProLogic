package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Customer;
import com.amitnadav.mywarehousemanager.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteCustomerByIdStep implements IStep {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void execute(Context context) {
        int customerId = (int) context.getValue(ContextConstants.CUSTOMER_ID);
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            customerRepository.deleteById(customerId);
        }
    }
}
