package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.repositories.SuppliersShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllSuppliersShipmentsStep implements IStep {

    @Autowired
    private SuppliersShipmentRepository repository;

    @Override
    public void execute(Context context) {
        context.setValue(ContextConstants.SUPPLIER_SHIPMENTS_LIST,repository.findAll());

    }
}
