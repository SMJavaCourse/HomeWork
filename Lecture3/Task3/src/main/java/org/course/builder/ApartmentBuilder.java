package org.course.builder;

import org.course.Apartment;
import org.course.features.Feature;

public class ApartmentBuilder {
    private int numberOfRooms;
    protected double price;
    private int apartmentNumber;
    private Feature[] features;

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

    public ApartmentBuilder features(Feature... features) {
        this.features = features;
        return this;
    }

    public Apartment build() {
        return new Apartment(numberOfRooms, price, apartmentNumber, features);
    }
}
