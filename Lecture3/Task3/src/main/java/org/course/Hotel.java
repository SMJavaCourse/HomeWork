package org.course;

public class Hotel {
    private String name;
    private Apartment[] apartments;
    private String checkInTime;

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public Hotel(String name, Apartment[] apartments, String checkInTime) {
        this.name = name;
        this.apartments = apartments;
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
}
