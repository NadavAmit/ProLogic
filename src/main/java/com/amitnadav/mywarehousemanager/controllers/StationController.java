package com.amitnadav.mywarehousemanager.controllers;

import com.amitnadav.mywarehousemanager.models.Station;
import com.amitnadav.mywarehousemanager.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    StationService stationService;

    @GetMapping({"","/"})
    public List<Station> getAllStations(){

        return stationService.getAllStations();
    }

    @GetMapping("/{id}")
    public Station getStationById(@PathVariable int id){
       return stationService.getStationById(id);
    }

    @PostMapping({"/",""})
    public void addNewStation(@RequestBody Station station){
        stationService.addNewStation(station);
    }

    @PatchMapping("/{id}/method")
    public void updateStationMethod(@PathVariable int id,@RequestBody Station station){
        stationService.updateStationMethod(id,station);
    }
}
