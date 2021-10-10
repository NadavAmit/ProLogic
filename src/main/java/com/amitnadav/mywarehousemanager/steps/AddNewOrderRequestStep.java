package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.OrderRequest;
import com.amitnadav.mywarehousemanager.repositories.OrderRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNewOrderRequestStep implements IStep {

    @Autowired
    OrderRequestRepository orderRequestRepository;

    @Override
    public void execute(Context context) {
        OrderRequest newOrderRequest = (OrderRequest) context.getValue(ContextConstants.NEW_ORDER_REQUEST);
        orderRequestRepository.save(newOrderRequest);
    }
}
