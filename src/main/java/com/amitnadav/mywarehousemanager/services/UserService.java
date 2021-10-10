package com.amitnadav.mywarehousemanager.services;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.User;
import com.amitnadav.mywarehousemanager.steps.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    GetAllUsersStep getAllUsersStep;
    @Autowired
    GetUserByIdStep getUserByIdStep;
    @Autowired
    AddNewUserStep addNewUserStep;
    @Autowired
    DeleteUserByIdStep deleteUserByIdStep;

    public List<User> getAllUsers(){
        Context context = new Context();
        getAllUsersStep.execute(context);
        List<User> users = (List<User>) context.getValue(ContextConstants.USERS_LIST);
        return users;
    }

    public User getUserById(Integer userId) {
        Context context = new Context();
        context.setValue(ContextConstants.USER_ID,userId);
        getUserByIdStep.execute(context);
        User user = (User) context.getValue(ContextConstants.USER);
        return user;
    }

    public void addNewUser(User user) {
        Context context = new Context();
        context.setValue(ContextConstants.USER,user);
        addNewUserStep.execute(context);
    }

    public void deleteUserById(Integer userId) {
        Context context = new Context();
        context.setValue(ContextConstants.USER_ID,userId);
        deleteUserByIdStep.execute(context);
    }
}
