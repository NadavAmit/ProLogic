package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Supplier;
import com.amitnadav.mywarehousemanager.models.SuppliersShipment;
import com.amitnadav.mywarehousemanager.repositories.SuppliersShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateSupplierShipment implements IStep {

    @Autowired
    SuppliersShipmentRepository repository;

    @Override
    public void execute(Context context) {
        int oldShipmentId = (int) context.getValue(ContextConstants.SUPPLIER_SHIPMENT_TO_UPDATE);
        SuppliersShipment newSupplierShipment = (SuppliersShipment) context.getValue(ContextConstants.NEW_SUPPLIER_SHIPMENT);
        Optional<SuppliersShipment> oldShipmentOptional = repository.findById(oldShipmentId);

        if(oldShipmentOptional.isPresent()){

            Supplier updatedSupplier = newSupplierShipment.getSupplier();


            oldShipmentOptional.get().setSupplier(updatedSupplier);

            repository.save(oldShipmentOptional.get());
        }
    }
}
