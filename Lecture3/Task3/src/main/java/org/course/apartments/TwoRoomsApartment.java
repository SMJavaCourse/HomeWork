package org.course.apartments;

import org.course.Apartment;

public class TwoRoomsApartment extends Apartment {

    public TwoRoomsApartment(int price, int capacity, int apartmentNumber, String[] additions) {
        super(2, price, capacity, apartmentNumber, additions);
    }
}