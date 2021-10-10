package com.amitnadav.mywarehousemanager.services;

import com.amitnadav.mywarehousemanager.models.Box;
import com.amitnadav.mywarehousemanager.repositories.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoxService {

    @Autowired
    private BoxRepository boxRepository;

    public List<Box> getAllBoxes() {
        List<Box> boxes = new ArrayList<>();
        boxRepository.findAll().forEach(boxes::add);
        return boxes;
    }

}
