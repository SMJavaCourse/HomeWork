package org.course.Builders;

import org.course.Amenity;
import org.course.Apartment;

import java.util.List;

public class ApartmentBuilder {
    public int num;
    public int apartment;
    public float price;
    public String checkInTime;
    private int people;
    private List<Amenity> amenities;

    public ApartmentBuilder num(int num) {
        this.num = num;
        return this;
    }

    public ApartmentBuilder apartment(int apartment) {
        this.apartment = apartment;
        return this;
    }

    public ApartmentBuilder price(float price) {
        this.price = price;
        return this;
    }

    public ApartmentBuilder checkInTime(String checkInTime) {
        this.checkInTime = checkInTime;
        return this;
    }

    public ApartmentBuilder capacity(int people) {
        this.people = people;
        return this;
    }

    public void amenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public Apartment build() {
        return new Apartment(num, apartment, price, checkInTime, people, amenities);
    }
}
