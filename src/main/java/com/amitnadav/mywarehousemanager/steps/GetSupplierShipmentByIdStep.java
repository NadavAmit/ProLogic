package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.SuppliersShipment;
import com.amitnadav.mywarehousemanager.repositories.SuppliersShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class GetSupplierShipmentByIdStep implements IStep{

    @Autowired
    SuppliersShipmentRepository repository;

    @Override
    public void execute(Context context) {
        Optional<SuppliersShipment> returnValueOptional = repository.findById((int) context.getValue(ContextConstants.SUPPLIER_SHIPMENT_ID));
        if(returnValueOptional.isPresent()){
        context.setValue(ContextConstants.SUPPLIER_SHIPMENT,returnValueOptional.get());
        }

    }
}
