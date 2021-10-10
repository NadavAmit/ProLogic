package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.User;
import com.amitnadav.mywarehousemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserByIdStep implements IStep {

    @Autowired
    UserRepository userRepository;

    @Override
    public void execute(Context context) {
      int userId = (int) context.getValue(ContextConstants.USER_ID);
      Optional<User> userOptional = userRepository.findById(userId);

      if(userOptional.isPresent()){
          userRepository.delete(userOptional.get());
      }
    }
}
