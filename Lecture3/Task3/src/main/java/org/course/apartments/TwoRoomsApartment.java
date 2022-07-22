package org.course.apartments;

import org.course.Apartment;
import org.course.additions.Addition;

import java.time.LocalTime;

public class TwoRoomsApartment extends Apartment {

    public TwoRoomsApartment(int price, int capacity, int apartmentNumber, Addition[] additions, LocalTime checkInTime) {
        super(2, price, capacity, apartmentNumber, additions, checkInTime);
    }
}