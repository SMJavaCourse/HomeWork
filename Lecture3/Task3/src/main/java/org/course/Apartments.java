package org.course;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Apartments implements Apartment{
    private String apartmentsTypeName;
    private Service services;
    private Float price;
    private Integer places;
    private Integer roomNumber;
    private LocalTime checkinTime;
    private List<Service> servicesList = new ArrayList<>();

    public Apartments(String apartmentsTypeName, float price, Integer places, int roomNumber) {
        this.apartmentsTypeName = apartmentsTypeName;
        this.price = price;
        this.places = places;
        this.roomNumber = roomNumber;
    }

    @Override
    public String getApartmentsTypeName() {
        return this.apartmentsTypeName;
    }
//    public void setApartmentsTypeName(String apartmentsTypeName) {
//       this.apartmentsTypeName = apartmentsTypeName;
//    }

    @Override
    public void setCheckinTime(LocalTime checkinTime) {
        this.checkinTime = checkinTime;
    }
    @Override
    public LocalTime getCheckinTime() {
        return checkinTime;
    }
    @Override
    public List<Service> getServicesList() {
        if  (this.servicesList != null) {
            return this.servicesList;
        } else {
            return List.of();
        }
    }

    @Override
    public Service getServices() {
        return this.services;
    }

    @Override
    public void setServices(Service services) {
        this.services = services;
    }

    @Override
    public void setServiceList(Service services) {
        this.servicesList.add(services);
    }

    public Apartment services(Service services) {
        this.services = services;
        this.servicesList.add(services);
        return this;
    }

    @Override
    public Integer getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public Integer getPlaces() {
        return this.places;
    }

    @Override
    public Float getPrice() {
        return this.price;
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
