package org.course;

public abstract class Apartment {
    protected Integer roomsNumber;
    protected String cost;
    protected Integer capacity;

    public Apartment(Integer roomsNumber, String cost, Integer capacity) {
        this.roomsNumber = roomsNumber;
        this.cost = cost;
        this.capacity = capacity;
    }

}

