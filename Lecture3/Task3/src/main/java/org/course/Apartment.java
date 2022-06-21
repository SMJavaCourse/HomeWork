package main.java.org.course;

import java.time.LocalTime;

public abstract class Apartment {
    private boolean balcony;
    private boolean internet;
    private boolean conditioner;
    private boolean cleaning;

    private boolean grillMeat;

    private float price;
    private int places;
    private int roomNumber;

    private LocalTime checkinTime;

    public float getPrice() {
        return price;
    }

    public int getPlaces() {
        return places;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Apartment(float price, int places, int roomNumber) {
        this.price = price;
        this.places = places;
        this.roomNumber = roomNumber;
    }

    public Apartment setCheckinTime(LocalTime checkinTime) {
        this.checkinTime = checkinTime;
        return this;
    }

    public LocalTime getCheckinTime() {
        return checkinTime;
    }

    public static void printAparts(Apartment[] apartments) {
        for (int i = 0; i < apartments.length; i++) {
            System.out.println(apartments[i].toString());
        }
    }

    public boolean isGrillMeat() {
        return grillMeat;
    }

    public Apartment setGrillMeat(boolean grillMeat) {
        this.grillMeat = grillMeat;
        return this;
    }


    public boolean isBalcony() {
        return balcony;
    }

    public Apartment setBalcony(boolean balcony) {
        this.balcony = balcony;
        return this;
    }

    public boolean isInternet() {
        return internet;
    }

    public Apartment setInternet(boolean internet) {
        this.internet = internet;
        return this;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    public Apartment setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
        return this;
    }

    public boolean isCleaning() {
        return cleaning;
    }

    public Apartment setCleaning(boolean cleaning) {
        this.cleaning = cleaning;
        return this;
    }

//    public float getPrice() {
//        return price;
//    }
//
//    public Apartment setPrice(float price) {
//        this.price = price;
//        return this;
//    }
//
//    public int getPlaces() {
//        return places;
//    }
//
//    public Apartment setPlaces(int places) {
//        this.places = places;
//        return this;
//    }
}
