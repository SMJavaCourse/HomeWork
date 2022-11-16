//package org.course;
//
//import lombok.Getter;
//
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//public abstract class Apartment_ implements Apartment {
//    private Services services;
//    private Float price;
//    private Integer places;
//    private Integer roomNumber;
//
//
//
//    private LocalTime checkinTime;
//    private List<Services> servicesList = new ArrayList<>();
//
//    public Apartment_() {
//
//    }
//
//    public List<Services> getServicesList() {
//        if  (this.servicesList != null) {
//            return this.servicesList;
//        } else {
//            return List.of();
//        }
//    }
//    public Apartment services(Services services) {
//        this.services = services;
//        this.servicesList.add(services);
//        return this;
//    }
//    public void setServices(Services services) {
//        this.services = services;
//        this.servicesList.add(services);
//    }
//    public void setCheckinTime(LocalTime checkinTime) {
//        this.checkinTime = checkinTime;
//    }
//
//    public Apartment_(float price, Integer places, int roomNumber) {
//        this.price = price;
//        this.places = places;
//        this.roomNumber = roomNumber;
//    }
//
//    @Override
//    public String toString() {
//        return getApartmentsTypeName() + " (комната номер " + getRoomNumber() + "): \n" +
//                "\tЦена: " + getPrice() + "\n" +
//                "\tВместительность: " + getPlaces() + "\n" +
//                "\tВремя заселение/выселения: " + getCheckinTime() + "\n" +
//                "\tДополнительные услуги: " + getServicesList();
//    }
//
//}