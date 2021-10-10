package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.*;
import com.amitnadav.mywarehousemanager.repositories.OrderRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidateOrderStep implements IStep {

    @Autowired
    OrderRequestRepository repository;


    @Override
    public void execute(Context context) {

        //Extracting Valdation Excetpions List
        List<ValidationException> validationExceptions =
                (List<ValidationException>) context.getValue(ContextConstants.VALIDATION_EXCEPTION_LIST);

        int orderRequestId = (int) context.getValue(ContextConstants.ORDER_REQUEST_ID);
        Optional<OrderRequest> orderRequestOptional = repository.findById(orderRequestId);

        if(orderRequestOptional.isPresent()){

            List<ProductRequest> productRequestList = orderRequestOptional.get().getProductsRequests();

            for (ProductRequest productRequest:productRequestList){
                Product currentProduct = productRequest.getProduct();
                int requestedQuantity = productRequest.getRequestedQuantity();
                int stockQuantity =  productRequest.getProduct().getStock();

                if(requestedQuantity > stockQuantity){

                    ValidationException exception = new ValidationException();
                    exception.setOutOfStockExcpetion(currentProduct,stockQuantity,requestedQuantity);
                    validationExceptions.add(exception);

                }

            }
             {
                
            }
        }
    }
}
