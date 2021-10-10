package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.*;
import com.amitnadav.mywarehousemanager.repositories.OrderRequestRepository;
import com.amitnadav.mywarehousemanager.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.Optional;

@Service
public class SubmitOrderStep implements IStep {

    @Autowired
    OrderRequestRepository orderRequestRepository;

        @Autowired
    ProductRepository productRepository;

    @Override
    public void execute(Context context) {
        int orderRequestId = (int) context.getValue(ContextConstants.ORDER_REQUEST_ID);
        Optional<OrderRequest> orderRequestOptional = orderRequestRepository.findById(orderRequestId);

        if(orderRequestOptional.isPresent()){
            for (ProductRequest productRequest: orderRequestOptional.get().getProductsRequests())
                {
                    if(productRequest.getStatus().equals("verified")){
                        int productId = productRequest.getId();
                        Optional<Product> productOptional = productRepository.findById(productId);
                        if(productOptional.isPresent()){
                            int requestedQuantity = productRequest.getRequestedQuantity();
                            int currentStock = productOptional.get().getStock();
                            int newStock = currentStock - requestedQuantity;

                            productOptional.get().setStock(newStock);

                            productRepository.save(productOptional.get());

                            productRequest.setStatus("submitted");
                        }

                    }
                }

            SubmissionSuccess submissionSuccess = new SubmissionSuccess(orderRequestOptional.get());
            context.setValue(ContextConstants.SUBMISSION_SUCCESS,submissionSuccess);
        }

    }
}
