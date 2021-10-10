package com.amitnadav.mywarehousemanager.services;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.IncomingProduct;
import com.amitnadav.mywarehousemanager.models.SuppliersShipment;
import com.amitnadav.mywarehousemanager.repositories.SuppliersShipmentRepository;
import com.amitnadav.mywarehousemanager.steps.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersShipmentService {

    @Autowired
    private SuppliersShipmentRepository suppliersShipmentRepository;

    @Autowired
    private GetAllSuppliersShipmentsStep getAllSuppliersShipmentsStep;

    @Autowired
    private GetSupplierShipmentByIdStep getSupplierShipmentByIdStep;

    @Autowired
    private AddSupplierShipmentStep addSupplierShipmentStep;

    @Autowired
    private UpdateSupplierShipment updateSupplierShipment;

    @Autowired
    private DeleteSupplierShipmentStep deleteSupplierShipmentStep;

    @Autowired
    private AddIncomingProductToShipmentStep addIncomingProductToShipmentStep;


    public List<SuppliersShipment> getAllSuppliersShipments() {
        Context context = new Context();
        getAllSuppliersShipmentsStep.execute(context);
        List<SuppliersShipment> suppliersShipments = (List<SuppliersShipment>) context.getValue(ContextConstants.SUPPLIER_SHIPMENTS_LIST);
        return suppliersShipments;
    }

    public SuppliersShipment getSupplierShipment(int id) {
        Context context = new Context();
        context.setValue(ContextConstants.SUPPLIER_SHIPMENT_ID,id);
        getSupplierShipmentByIdStep.execute(context);
        SuppliersShipment suppliersShipment = (SuppliersShipment)context.getValue(ContextConstants.SUPPLIER_SHIPMENT);
        return suppliersShipment;
    }

    public void addSuppliersShipment(SuppliersShipment newShipment) {
        Context context = new Context();
        context.setValue(ContextConstants.NEW_SUPPLIER_SHIPMENT,newShipment);
        addSupplierShipmentStep.execute(context);

    }

    public void deleteSupplierShipment(int id) {
        Context context = new Context();
        context.setValue(ContextConstants.SUPPLIER_SHIPMENT_TO_DELETE,id);
        deleteSupplierShipmentStep.execute(context);

    }

    public void updateSuppliersShipment(SuppliersShipment suppliersShipment, int id) {
        Context context = new Context();
        context.setValue(ContextConstants.SUPPLIER_SHIPMENT_TO_UPDATE,id);
        context.setValue(ContextConstants.NEW_SUPPLIER_SHIPMENT,suppliersShipment);
        updateSupplierShipment.execute(context);


    }

    public void addIncomingProductToShipment(IncomingProduct newIncomingProduct) {
        Context context = new Context();
        context.setValue(ContextConstants.INCOMING_PRODUCT,newIncomingProduct);
        addIncomingProductToShipmentStep.execute(context);

    }
}
