package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Supplier;
import com.amitnadav.mywarehousemanager.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNewSupplierStep implements IStep {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public void execute(Context context) {
        Supplier newSupplier = (Supplier) context.getValue(ContextConstants.SUPPLIER);
        supplierRepository.save(newSupplier);
    }
}
