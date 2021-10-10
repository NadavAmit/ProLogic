package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.User;
import com.amitnadav.mywarehousemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNewUserStep implements IStep {

    @Autowired
    UserRepository userRepository;

    @Override
    public void execute(Context context) {
        User newUser = (User) context.getValue(ContextConstants.USER);
        userRepository.save(newUser);
    }
}
