package com.amitnadav.mywarehousemanager.services;

import com.amitnadav.mywarehousemanager.constants.ContextConstants;
import com.amitnadav.mywarehousemanager.models.Context;
import com.amitnadav.mywarehousemanager.models.Station;
import com.amitnadav.mywarehousemanager.steps.AddNewStationStep;
import com.amitnadav.mywarehousemanager.steps.GetAllStationsStep;
import com.amitnadav.mywarehousemanager.steps.GetStationByIdStep;
import com.amitnadav.mywarehousemanager.steps.UpdateStationMethodStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    GetAllStationsStep getAllStationsStep;

    @Autowired
    GetStationByIdStep getStationByIdStep;

    @Autowired
    AddNewStationStep addNewStationStep;

    @Autowired
    UpdateStationMethodStep updateStationMethodStep;

    public List<Station> getAllStations() {
        Context context = new Context();
        getAllStationsStep.execute(context);
        List<Station> stationList = (List<Station>) context.getValue(ContextConstants.STATION_LIST);
        return stationList;
    }

    public Station getStationById(int id) {
        Context context = new Context();
        context.setValue(ContextConstants.STATION_ID,id);
        getStationByIdStep.execute(context);
        Station station = (Station) context.getValue(ContextConstants.STATION);
        return station;
    }

    public void addNewStation(Station station) {
        Context context = new Context();
        context.setValue(ContextConstants.STATION,station);
        addNewStationStep.execute(context);
    }

    public void updateStationMethod(int id, Station station) {
        Context context = new Context();
        context.setValue(ContextConstants.STATION_ID,id);
        context.setValue(ContextConstants.STATION,station);
        updateStationMethodStep.execute(context);
    }
}
