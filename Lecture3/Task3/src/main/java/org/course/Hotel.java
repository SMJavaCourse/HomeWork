package org.course;

public class Hotel implements Sout{
    private String name;
    private Apartment[] apartments;
    private String startTime;

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
