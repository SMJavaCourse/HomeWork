package org.course;

public class Apartment {
    private int price;
    private int capacity;
    private int roomNumber;
    private int numberOfRooms;
    private boolean balcony;
    private boolean cleaning;
    private boolean internet;
    private boolean conditioner;
    private boolean meat;
    private boolean jacuzzi;

    public Apartment(int numberOfRooms, int price, int roomNumber, int capacity, boolean balcony,
                     boolean cleaning, boolean internet, boolean conditioner, boolean meat, boolean jacuzzi) {
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.balcony = balcony;
        this.cleaning = cleaning;
        this.internet = internet;
        this.conditioner = conditioner;
        this.meat = meat;
        this.jacuzzi = jacuzzi;
    }

    public boolean isBalcony() {
        return balcony;
    }
    public boolean isCleaning() {
        return cleaning;
    }
    public boolean isInternet() {
        return internet;
    }
    public boolean isConditioner() {
        return conditioner;
    }
    public boolean isMeat() {
        return meat;
    }
    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public int getPrice() {
        return price;
    }
    public String getNamesForNumberOfRooms(int numberOfRooms) {
        if (numberOfRooms == 1) {
            return "Однокомнатный номер";
        }
        if (numberOfRooms == 2) {
            return "Двухкомнатный номер";
        }
        if (numberOfRooms == 3) {
            return "Трёхкомнатный номер";
        }
        return null;
    }
}
