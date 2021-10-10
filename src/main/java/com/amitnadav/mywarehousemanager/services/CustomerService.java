package com.amitnadav.mywarehousemanager.services;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Customer;
import com.amitnadav.mywarehousemanager.models.SuppliersShipment;
import com.amitnadav.mywarehousemanager.steps.AddNewCustomerStep;
import com.amitnadav.mywarehousemanager.steps.DeleteCustomerByIdStep;
import com.amitnadav.mywarehousemanager.steps.GetAllCustomersStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    GetAllCustomersStep getAllCustomersStep;

    @Autowired
    AddNewCustomerStep addNewCustomerStep;

    @Autowired
    DeleteCustomerByIdStep deleteCustomerByIdStep;

    public List<Customer> getAllCustomers() {

        Context context = new Context();
        getAllCustomersStep.execute(context);
        List<Customer> customers = (List<Customer>) context.getValue(ContextConstants.CUSTOMERS_LIST);
        return customers;
    }

    public void addNewCustomer(Customer customer) {
        Context context = new Context();
        context.setValue(ContextConstants.CUSTOMER,customer);
        addNewCustomerStep.execute(context);
    }

    public void deleteCustomerById(int customerId) {
        Context context = new Context();
        context.setValue(ContextConstants.CUSTOMER_ID,customerId);
        deleteCustomerByIdStep.execute(context);

    }
}
