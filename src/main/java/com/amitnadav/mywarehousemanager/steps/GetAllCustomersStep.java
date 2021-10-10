package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllCustomersStep implements IStep {
    @Autowired
    CustomerRepository repository;

    @Override
    public void execute(Context context) {
        context.setValue(ContextConstants.CUSTOMERS_LIST,repository.findAll());
        }
}
