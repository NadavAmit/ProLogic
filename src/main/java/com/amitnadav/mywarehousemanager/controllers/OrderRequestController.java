package com.amitnadav.mywarehousemanager.controllers;

import com.amitnadav.mywarehousemanager.models.OrderRequest;
import com.amitnadav.mywarehousemanager.models.SubmissionStatus;
import com.amitnadav.mywarehousemanager.models.ValidationException;
import com.amitnadav.mywarehousemanager.services.OrderRequestService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderRequestController {

    @Autowired
    OrderRequestService orderRequestService;

    @GetMapping({"","/"})
    public List<OrderRequest> getAllOrderRequests(){

        return orderRequestService.getAllOrderRequests();
    }

    @PostMapping({"","/"})
    public void addNewOrderRequest(@RequestBody OrderRequest orderRequest){
        orderRequestService.addNewOrderRequest(orderRequest);
    }
    @PostMapping("/{orderRequestId}/submit")
    public List<? extends SubmissionStatus> SubmitOrderRequest(@PathVariable int orderRequestId){

        return orderRequestService.submitOrderRequest(orderRequestId);


    }
}
