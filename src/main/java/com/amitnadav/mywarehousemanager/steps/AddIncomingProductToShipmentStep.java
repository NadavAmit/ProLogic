package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.IncomingProduct;
import com.amitnadav.mywarehousemanager.models.Supplier;
import com.amitnadav.mywarehousemanager.models.SuppliersShipment;
import com.amitnadav.mywarehousemanager.repositories.SuppliersShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddIncomingProductToShipmentStep implements IStep {

    @Autowired
    SuppliersShipmentRepository suppliersShipmentRepository;

    @Override
    public void execute(Context context) {
        IncomingProduct newIncomingProduct = (IncomingProduct) context.getValue(ContextConstants.INCOMING_PRODUCT);
        int suppliersShipmentId = newIncomingProduct.getSuppliersShipment().getShipmentId();
        Optional<SuppliersShipment> updatedSupplierShipmentOptional = suppliersShipmentRepository.findById(suppliersShipmentId);
       if(updatedSupplierShipmentOptional.isPresent()){
            List<IncomingProduct> incomingProductsList = updatedSupplierShipmentOptional.get().getIncomingProductsList();
            incomingProductsList.add(newIncomingProduct);
            suppliersShipmentRepository.save(updatedSupplierShipmentOptional.get());
        }
    }
}
