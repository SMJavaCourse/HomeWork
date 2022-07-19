package org.course;

import java.util.Arrays;


public class Hotel {
    private String name;
    private Apartment[] apartments;
    private String checkInTime;

    public Hotel(String name, Apartment[] apartments, String checkInTime) {
        this.name = name;
        this.apartments = apartments;
        this.checkInTime = checkInTime;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
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
