package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Station;
import com.amitnadav.mywarehousemanager.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateStationMethodStep implements  IStep{

    @Autowired
    StationRepository stationRepository;

    @Override
    public void execute(Context context) {
        Station newStation = (Station) context.getValue(ContextConstants.STATION);
        int oldStationId = (int) context.getValue(ContextConstants.STATION_ID);
        Optional<Station> oldStationOptional = stationRepository.findById(oldStationId);
        if(oldStationOptional.isPresent()){
            Station updatedStation = oldStationOptional.get();
            updatedStation.setCurrentMethod(newStation.getCurrentMethod());
            updatedStation.setLeftSideBoxesSize(newStation.getLeftSideBoxesSize());
            updatedStation.setRightSideBoxesSize(newStation.getRightSideBoxesSize());
            stationRepository.save(updatedStation);
        }
    }
}
