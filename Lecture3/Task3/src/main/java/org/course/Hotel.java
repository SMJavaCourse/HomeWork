package org.course;

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
}
