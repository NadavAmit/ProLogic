package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.SuppliersShipment;
import com.amitnadav.mywarehousemanager.repositories.SuppliersShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddSupplierShipmentStep implements IStep {

    @Autowired
    private SuppliersShipmentRepository repository;


    @Override
    public void execute(Context context) {
        SuppliersShipment newShipment = (SuppliersShipment) context.getValue(ContextConstants.NEW_SUPPLIER_SHIPMENT);
        repository.save(newShipment);
    }
}
