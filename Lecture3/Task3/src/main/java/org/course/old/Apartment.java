package org.course.old;

public class Apartment {
    private int price;
    private int capacity;
    private int roomNumber;
    private String startTime;
    private String numberOfRooms;
    private String balcony;
    private String cleaning;
    private String internet;
    private String conditioner;
    private String meat;

    public Apartment(String numberOfRooms, int price, int roomNumber, int capacity, String startTime, String balcony,
                     String cleaning, String internet, String conditioner, String meat) {
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.balcony = balcony;
        this.cleaning = cleaning;
        this.internet = internet;
        this.conditioner = conditioner;
        this.meat = meat;
        this.startTime = startTime;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public String getCleaning() {
        return cleaning;
    }
    public String getInternet() {
        return internet;
    }
    public String getConditioner() {
        return conditioner;
    }
    public String getMeat() {
        return meat;
    }
    public String getBalcony() {
        return balcony;
    }

    public int getPrice() {
        return price;
    }

    public String getStartTime() {
        return startTime;
    }
}
