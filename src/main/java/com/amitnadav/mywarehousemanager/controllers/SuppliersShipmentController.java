package com.amitnadav.mywarehousemanager.controllers;

import com.amitnadav.mywarehousemanager.models.IncomingProduct;
import com.amitnadav.mywarehousemanager.models.SuppliersShipment;
import com.amitnadav.mywarehousemanager.services.SuppliersShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("suppliers-shipments")
public class SuppliersShipmentController {

    @Autowired
    private SuppliersShipmentService suppliersShipmentService;

    @GetMapping({"/",""})
    public List<SuppliersShipment> getAllSuppliersShipments(){
       return suppliersShipmentService.getAllSuppliersShipments();

    }
    @PostMapping({"", "/"})
    public void addSuppliersShipment(@RequestBody SuppliersShipment newShipment){
        suppliersShipmentService.addSuppliersShipment(newShipment);
    }
    @GetMapping("/{Id}")
    public SuppliersShipment getSuppliersShipment(@PathVariable int Id){
        return suppliersShipmentService.getSupplierShipment(Id);
    }
    @DeleteMapping("/{id}")
    public void deleteSuppliersShipment(@PathVariable int id){
        suppliersShipmentService.deleteSupplierShipment(id);
    }

    @PutMapping("/{id}")
    public void updateSuppliersShipment (@RequestBody SuppliersShipment suppliersShipment
            ,@PathVariable int id){
        suppliersShipmentService.updateSuppliersShipment(suppliersShipment,id);
    }

    @PostMapping("/incoming-product")
    public void addIncomingProductToShipment(@RequestBody IncomingProduct newIncomingProduct){
        suppliersShipmentService.addIncomingProductToShipment(newIncomingProduct);
    }






}
