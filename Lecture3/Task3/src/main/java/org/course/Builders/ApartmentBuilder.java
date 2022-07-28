package org.course.Builders;

import org.course.Apartment;
import org.course.Hotel;

public class ApartmentBuilder {
    public int num;
    public int apartment;
    public float price;
    public String checkInTime;
    private int people;

    public boolean isBalcony;
    public boolean isCleaning;
    public boolean isInternet;
    public boolean isCooling;
    public boolean isGrillInNumber;

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

    public ApartmentBuilder isBalcony(boolean isBalcony) {
        this.isBalcony = isBalcony;
        return this;
    }

    public ApartmentBuilder isCleaning(boolean isCleaning) {
        this.isCleaning = isCleaning;
        return this;
    }

    public ApartmentBuilder isInternet(boolean isInternet) {
        this.isInternet = isInternet;
        return this;
    }

    public ApartmentBuilder isCooling(boolean isCooling) {
        this.isCooling = isCooling;
        return this;
    }

    public ApartmentBuilder isGrillInNumber(boolean isGrillInNumber) {
        this.isGrillInNumber = isGrillInNumber;
        return this;
    }

    public Apartment build() {
        return new Apartment(num, apartment, price, checkInTime, people, isBalcony, isCleaning, isInternet, isCooling, isGrillInNumber);
    }
}
