package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Supplier;
import com.amitnadav.mywarehousemanager.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetSupplierByIdStep implements IStep {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public void execute(Context context) {
        int id = (int) context.getValue(ContextConstants.SUPPLIER_ID);
        Optional<Supplier> supplierOptional  = supplierRepository.findById(id);
        if(supplierOptional.isPresent()){
            context.setValue(ContextConstants.SUPPLIER,supplierOptional.get());
        }
    }
}
