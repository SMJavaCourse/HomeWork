package org.course;

public class Apartment {
    private final int price;
    private final int capacity;
    private final int roomNumber;
    private final String numberOfRooms;
    private final String startTime;
    private final boolean balcony;
    private final boolean cleaning;
    private final boolean internet;
    private final boolean conditioner;
    private final boolean meat;

    public Apartment(String numberOfRooms, String startTime,int price, int roomNumber, int capacity, boolean balcony,
                     boolean cleaning, boolean internet, boolean conditioner, boolean meat) {
        this.numberOfRooms = numberOfRooms;
        this.startTime = startTime;
        this.price = price;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.balcony = balcony;
        this.cleaning = cleaning;
        this.internet = internet;
        this.conditioner = conditioner;
        this.meat = meat;
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

    public String getNumberOfRooms() {
        return numberOfRooms;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public int getPrice() {
        return price;
    }
    public String getStartTime() {
        return startTime;
    }

}
