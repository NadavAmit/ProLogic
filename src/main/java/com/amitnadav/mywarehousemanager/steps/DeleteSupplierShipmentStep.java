package com.amitnadav.mywarehousemanager.steps;

import ch.qos.logback.classic.selector.ContextSelector;
import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.SuppliersShipment;
import com.amitnadav.mywarehousemanager.repositories.SuppliersShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DeleteSupplierShipmentStep implements IStep {

    @Autowired
    SuppliersShipmentRepository repository;
    @Override
    public void execute(Context context) {
        int shipmentToDeleteId = (int) context.getValue(ContextConstants.SUPPLIER_SHIPMENT_TO_DELETE);
        repository.deleteById(shipmentToDeleteId);
    }
}
