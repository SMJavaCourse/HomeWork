package org.course;

import java.util.Arrays;

public class Hotel {
    private String name;
    private Apartment[] apartments;

    public Hotel(String name, Apartment[] apartments) {
        this.name = name;
        this.apartments = apartments;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Apartment[] getRooms() {
        return apartments;
    }

    public void setRooms(Apartment[] apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", apartments=" + Arrays.toString(apartments) +
                '}';
    }
}
