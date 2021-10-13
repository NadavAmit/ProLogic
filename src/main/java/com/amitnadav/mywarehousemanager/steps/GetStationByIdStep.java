package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Station;
import com.amitnadav.mywarehousemanager.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetStationByIdStep implements IStep {

    @Autowired
    StationRepository stationRepository;

    @Override
    public void execute(Context context) {
        int id = (int) context.getValue(ContextConstants.STATION_ID);
        Optional<Station> stationOptional = stationRepository.findById(id);
        if(stationOptional.isPresent()){
            context.setValue(ContextConstants.STATION,stationOptional.get());
        }
    }
}
