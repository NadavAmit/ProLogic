package com.amitnadav.mywarehousemanager.services;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.*;
import com.amitnadav.mywarehousemanager.steps.AddNewOrderRequestStep;
import com.amitnadav.mywarehousemanager.steps.GetAllOrderRequestsStep;
import com.amitnadav.mywarehousemanager.steps.SubmitOrderStep;
import com.amitnadav.mywarehousemanager.steps.ValidateOrderStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderRequestService {

    @Autowired
    ValidateOrderStep validateOrderStep;

    @Autowired
    SubmitOrderStep submitOrderStep;

    @Autowired
    GetAllOrderRequestsStep getAllOrderRequestsStep;

    @Autowired
    AddNewOrderRequestStep addNewOrderRequestStep;

    public List<? extends SubmissionStatus> submitOrderRequest(int orderRequestId){
        Context context = new Context();
        List<ValidationException> validationExceptionList = new ArrayList<>();
        context.setValue(ContextConstants.ORDER_REQUEST_ID,orderRequestId);
        context.setValue(ContextConstants.VALIDATION_EXCEPTION_LIST,validationExceptionList);
        validateOrderStep.execute(context);
        validationExceptionList =
                (List<ValidationException>) context.getValue(ContextConstants.VALIDATION_EXCEPTION_LIST);
        if(! validationExceptionList.isEmpty()){return validationExceptionList;}

        submitOrderStep.execute(context);
        SubmissionSuccess submissionSuccess = (SubmissionSuccess) context.getValue(ContextConstants.SUBMISSION_SUCCESS);
        return (List<? extends SubmissionStatus>) submissionSuccess;


    }

    public List<OrderRequest> getAllOrderRequests() {

        Context context = new Context();
        getAllOrderRequestsStep.execute(context);
        List<OrderRequest> lst = (List<OrderRequest>) context.getValue(ContextConstants.ORDER_REQUEST_LIST);
        return lst;
    }

    public void addNewOrderRequest(OrderRequest orderRequest) {
        Context context = new Context();
        context.setValue(ContextConstants.NEW_ORDER_REQUEST,orderRequest);
        addNewOrderRequestStep.execute(context);

    }
}
