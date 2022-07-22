package org.course.apartments;

import org.course.Apartment;
import org.course.additions.Addition;

import java.time.LocalTime;

public class OneRoomApartment extends Apartment {

    public OneRoomApartment(int price, int capacity, int apartmentNumber, Addition[] additions, LocalTime checkInTime) {
        super(1, price, capacity, apartmentNumber, additions, checkInTime);
    }
}