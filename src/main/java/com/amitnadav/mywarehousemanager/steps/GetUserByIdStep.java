package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.User;
import com.amitnadav.mywarehousemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class GetUserByIdStep implements IStep {

    @Autowired
    UserRepository repository;

    @Override
    public void execute(Context context) {
        Integer value = (Integer) context.getValue(ContextConstants.USER_ID);
        Optional<User> userOptinal = repository.findById(value);
        if(userOptinal.isPresent()){
            context.setValue(ContextConstants.USER,userOptinal.get());
        }



    }
}
