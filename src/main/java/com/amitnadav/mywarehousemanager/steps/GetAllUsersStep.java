package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllUsersStep implements IStep {

    @Autowired
    UserRepository userRepository;

    @Override
    public void execute(Context context) {
        context.setValue(ContextConstants.USERS_LIST,userRepository.findAll());
    }
}
