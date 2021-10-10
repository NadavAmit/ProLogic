package com.amitnadav.mywarehousemanager.controllers;

import com.amitnadav.mywarehousemanager.models.User;
import com.amitnadav.mywarehousemanager.repositories.UserRepository;
import com.amitnadav.mywarehousemanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping({"/",""})
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Integer userId){
        return userService.getUserById(userId);
    }

    @PostMapping({"/",""})
    public void addUser(@RequestBody User user) {userService.addNewUser(user);}

    @DeleteMapping("/{userId}")
    public void deleteUser (@PathVariable Integer userId){userService.deleteUserById(userId);}
}
