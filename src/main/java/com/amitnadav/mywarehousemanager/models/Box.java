package com.amitnadav.mywarehousemanager.models;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Box {

    @Id
    private int boxId;
    private int boxSize;
    private int boxPartition;
    private boolean isEmpty;
    private String contains;

    public Box(int boxId, int boxSize, int boxPartition) {
        this.boxId = boxId;
        this.boxSize = boxSize;
        this.boxPartition = boxPartition;
    }

    public int getBoxId() {
        return boxId;
    }


    public int getBoxSize() {
        return boxSize;
    }

    public int getBoxPartition() {
        return boxPartition;
    }

    public void setBoxPartition(int boxPartition) {
        this.boxPartition = boxPartition;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public String getContains() {
        return contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }
}
