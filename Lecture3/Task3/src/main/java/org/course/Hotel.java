package org.course;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private Apartment[] apartments;
    private String startTime;

    public Hotel(String name, String startTime,Apartment[] apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public Apartment[] getRooms() {
        return apartments;
    }

    public String getStartTime() {
        return startTime;
    }

    public void soutTitle(String name, int numberOfApartments) {
        System.out.println("Отель \"" + name + "\"");
        System.out.println("Количество номеров: " + numberOfApartments);
        System.out.println("Номера:");
    }
}
