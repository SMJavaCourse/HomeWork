package org.course;

public class Hotel implements Sout {
    private final String name;
    private final Apartment[] apartments;

    public Hotel(String name, Apartment[] apartments) {
        this.name = name;
        this.apartments = apartments;
    }

    public String getName() {
        return name;
    }

    public Apartment[] getRooms() {
        return apartments;
    }
}
