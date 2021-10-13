package com.amitnadav.mywarehousemanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Elevator {

    @Id
    @Column(name = "elevator_id")
    private int elevatorID;

    private String location;
    private String state;

    @ManyToOne
    @JoinColumn(name = "stationId")
    private Station station;

}
