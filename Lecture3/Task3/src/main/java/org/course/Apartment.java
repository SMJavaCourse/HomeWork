package org.course;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Apartment implements Apartments {
    public Apartment setServices(Services services) {
        this.services = services;
        this.servicesList.add(services);
        return this;
    }

    private Services services;
    private List<Services> servicesList = new ArrayList<>();

    public List<Services> getServicesList() {
        if  (this.servicesList != null) {
            return this.servicesList;
        } else {
            return List.of();
        }
    }

    private float price;
    private int places;
    private int roomNumber;

    private LocalTime checkinTime;

    public float getPrice() {
        return price;
    }

    public Integer getPlaces() {
        return places;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Apartment(float price, Integer places, int roomNumber) {
        this.price = price;
        this.places = places;
        this.roomNumber = roomNumber;
    }

    public void setCheckinTime(LocalTime checkinTime) {
        this.checkinTime = checkinTime;
    }
    public LocalTime getCheckinTime() {
        return checkinTime;
    }

    public Services getServices() {
        return this.services;
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
