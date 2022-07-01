package org.course.apartments;

import org.course.Apartment;

public class OneRoomApartment extends Apartment {

    public OneRoomApartment(int price, int capacity, int apartmentNumber, String[] additions) {
        super(1, price, capacity, apartmentNumber, additions);
    }
}