package com.amitnadav.mywarehousemanager.controllers;

import com.amitnadav.mywarehousemanager.models.Supplier;
import com.amitnadav.mywarehousemanager.models.SuppliersShipment;
import com.amitnadav.mywarehousemanager.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping({"","/"})
    public List<Supplier> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{Id}")
    public Supplier getSupplierById(@PathVariable Integer Id){
        return supplierService.getSupplierById(Id);
    }

    @PostMapping({"","/"})
    public void addNewSupplier(@RequestBody Supplier supplier){
                supplierService.addNewSupplier(supplier);
    }


}
