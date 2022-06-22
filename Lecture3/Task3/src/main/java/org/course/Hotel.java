package org.course;

public class Hotel {
    private String name;
    private Apartment[] apartments;
    private String checkin;

    public Hotel(String name, Apartment[] apartments, String checkin) {
        this.name = name;
        this.apartments = apartments;
        this.checkin = checkin;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public Apartment[] getRooms() {return apartments;}

    public void setRooms(Apartment[] apartments) {
        this.apartments = apartments;
    }
    public String getCheckin() {return checkin;}
}
