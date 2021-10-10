package com.amitnadav.mywarehousemanager.services;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Supplier;
import com.amitnadav.mywarehousemanager.models.SuppliersShipment;
import com.amitnadav.mywarehousemanager.repositories.SupplierRepository;
import com.amitnadav.mywarehousemanager.steps.AddNewSupplierStep;
import com.amitnadav.mywarehousemanager.steps.GetSupplierByIdStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    GetSupplierByIdStep getSupplierByIdStep;

    @Autowired
    AddNewSupplierStep addNewSupplierStep;

    public List<Supplier> getAllSuppliers() {
         List<Supplier> supplierList = (List<Supplier>) supplierRepository.findAll();
         return supplierList;
    }

    public Supplier getSupplierById(Integer id) {
        Context context = new Context();
        context.setValue(ContextConstants.SUPPLIER_ID,id);
        getSupplierByIdStep.execute(context);
        Supplier supplier = (Supplier) context.getValue(ContextConstants.SUPPLIER);
        return supplier;
    }

    public void addNewSupplier(Supplier supplier) {
        Context context = new Context();
        context.setValue(ContextConstants.SUPPLIER,supplier);
        addNewSupplierStep.execute(context);

    }
}
