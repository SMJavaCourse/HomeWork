package main.java.org.course;

import java.time.LocalTime;

public class HotelBuilder {

    private String name;
    private LocalTime checkInTime;
    private Apartment[] apartments;

    public HotelBuilder name(String name) {
        this.name = name;
        return this;
    }
    public HotelBuilder checkInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
        return this;
    }
    public HotelBuilder apartments(Apartment[] apartments) {
        this.apartments = apartments;
        return this;
    }

    public Hotel build() {
        return new Hotel(name, apartments, checkInTime);
    }

}
