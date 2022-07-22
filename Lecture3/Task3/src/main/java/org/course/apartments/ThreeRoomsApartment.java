package org.course.apartments;

import org.course.Apartment;
import org.course.additions.Addition;

import java.time.LocalTime;

public class ThreeRoomsApartment extends Apartment {

    public ThreeRoomsApartment(int price, int capacity, int apartmentNumber, Addition[] additions, LocalTime checkInTime) {
        super(3, price, capacity, apartmentNumber, additions, checkInTime);
    }
}