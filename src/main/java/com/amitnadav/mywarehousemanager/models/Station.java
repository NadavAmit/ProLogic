package com.amitnadav.mywarehousemanager.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {

    @Id
    private int stationId;

    @Column(name = "method")
    private String currentMethod;

    @Column(name = "left_boxes_size")
    private String rightSideBoxesSize;

    @Column(name = "right_boxes_size")
    private String leftSideBoxesSize;

    @OneToOne(mappedBy = "station")
    private Elevator rightElevator;

    @OneToOne(mappedBy = "station")
    private Elevator leftElevator;


}
