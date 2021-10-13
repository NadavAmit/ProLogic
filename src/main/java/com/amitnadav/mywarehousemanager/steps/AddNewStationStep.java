package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Station;
import com.amitnadav.mywarehousemanager.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNewStationStep implements IStep {

    @Autowired
    StationRepository stationRepository;

    @Override
    public void execute(Context context) {
        Station newStation = (Station) context.getValue(ContextConstants.STATION);
        stationRepository.save(newStation);
    }
}
