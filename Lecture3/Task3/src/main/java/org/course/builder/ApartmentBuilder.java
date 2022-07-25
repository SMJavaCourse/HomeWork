package org.course.builder;

import org.course.Apartment;
import org.course.features.Feature;
import org.course.features.construct.AirConditioner;

import java.util.List;

public class ApartmentBuilder {
    private int numberOfRooms;
    protected double price;
    private int apartmentNumber;
    private int numberOfPeople;
    private List<Feature> features;

    public ApartmentBuilder numberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
        return this;
    }

    public ApartmentBuilder price(Double price) {
        this.price = price;
        return this;
    }

    public ApartmentBuilder apartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
        return this;
    }
    public ApartmentBuilder numberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
        return this;
    }
//    public ApartmentBuilder features(Feature... features) {
//        this.features = List.of(features);
//        return this;
//    }
    public ApartmentBuilder features(List<Feature> features) {
        this.features = features;
        this.features.add(new AirConditioner());
        return this;
    }

    public Apartment build() {
        return new Apartment(numberOfRooms, price, apartmentNumber, numberOfPeople, features);
    }
}
