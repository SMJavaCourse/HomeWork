package org.course;

import org.course.services.Services;

public class ThreeRoomsApartment extends Apartment{

    public ThreeRoomsApartment(int numberOfRoom, int price, Services... services) {
        super(numberOfRoom, price, services);
    }

    public String getName(){
        return "Трёхкомнатный номер";
    }
}