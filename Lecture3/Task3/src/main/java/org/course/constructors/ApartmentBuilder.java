package org.course.constructors;

import org.course.services.Services;

public class ApartmentBuilder {

    private String name;
    private int price;
    private int rooms;
    private int numberOfRoom;
    private int capacity;
    private Services[] services;

    public ApartmentBuilder(String name, int price, int rooms, int numberOfRoom, int capacity, Services[] services) {
        this.name = name;
        this.price = price;
        this.rooms = rooms;
        this.numberOfRoom = numberOfRoom;
        this.capacity = capacity;
        this.services = services;
    }
}
