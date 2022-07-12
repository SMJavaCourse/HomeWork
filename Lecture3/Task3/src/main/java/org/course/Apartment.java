package org.course;

import java.time.LocalTime;
import java.util.List;

public abstract class Apartment implements Apartments {
    private List<Services> servicesList;

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

    public Apartment(float price, int places, int roomNumber, List<Services> servicesList) {
        this.price = price;
        this.places = places;
        this.roomNumber = roomNumber;
        this.servicesList = servicesList;
    }

    public void setCheckinTime(LocalTime checkinTime) {
        this.checkinTime = checkinTime;
    }
    public LocalTime getCheckinTime() {
        return checkinTime;
    }

    public List<Services> getServicesList() {
        return this.servicesList;
    }

    @Override
    public String toString() {
        return getApartmentsTypeName() + " (комната номер " + getRoomNumber() + "): \n" +
                "\tЦена: " + getPrice() + "\n" +
                "\tВместительность: " + getPlaces() + "\n" +
                "\tВремя заселение/выселения: " + getCheckinTime() + "\n" +
                "\tДополнительные услуги: " + getServicesList();
    }

}
