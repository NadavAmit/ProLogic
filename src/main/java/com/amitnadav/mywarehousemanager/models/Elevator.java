package com.amitnadav.mywarehousemanager.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Elevator {
    @Id
    private int elevatorID;
    private String location;
    private String state;

}
