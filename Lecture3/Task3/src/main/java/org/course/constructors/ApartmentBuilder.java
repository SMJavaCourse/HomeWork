package org.course.constructors;

import org.course.Apartment;
import org.course.services.Services;

public class ApartmentBuilder {

    private int price;
    private int rooms;
    private int numberOfRoom;
    private int capacity;
    private Services[] services;

    public ApartmentBuilder price(int price) {
        this.price = price;
        return this;
    }

    public ApartmentBuilder rooms(int rooms) {
        this.rooms = rooms;
        return this;
    }

    public ApartmentBuilder numberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
        return this;
    }

    public ApartmentBuilder capacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public ApartmentBuilder services(Services... services) {
        this.services = services;
        return this;
    }

    public Apartment build() {
        return new Apartment(rooms, numberOfRoom, price, capacity, services);
    }
}