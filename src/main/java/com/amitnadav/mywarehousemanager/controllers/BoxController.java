package com.amitnadav.mywarehousemanager.controllers;

import com.amitnadav.mywarehousemanager.models.Box;
import com.amitnadav.mywarehousemanager.services.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoxController {

    @Autowired
    private BoxService boxService;

    @RequestMapping("/boxes")
    public List<Box> getAllBoxes(){return boxService.getAllBoxes();}

}
