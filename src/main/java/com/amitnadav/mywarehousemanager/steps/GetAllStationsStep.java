package com.amitnadav.mywarehousemanager.steps;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Station;
import com.amitnadav.mywarehousemanager.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllStationsStep implements IStep {

    @Autowired
    StationRepository stationRepository;

    @Override
    public void execute(Context context) {
        List<Station> stationList = (List<Station>) stationRepository.findAll();
        context.setValue(ContextConstants.STATION_LIST,stationList);
    }
}
