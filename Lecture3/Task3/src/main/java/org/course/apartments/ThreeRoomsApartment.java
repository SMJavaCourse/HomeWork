package org.course.apartments;

import org.course.Apartment;

public class ThreeRoomsApartment extends Apartment {

    public ThreeRoomsApartment(int price, int capacity, int apartmentNumber, String[] additions) {
        super(3, price, capacity, apartmentNumber, additions);
    }
}