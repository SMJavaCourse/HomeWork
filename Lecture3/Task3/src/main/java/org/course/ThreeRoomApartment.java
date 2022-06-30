package org.course;

import org.course.features.Feature;

public class ThreeRoomApartment extends Apartment {
    private static final int NUMBER_OF_ROOMS = 3;

    public ThreeRoomApartment(double price, int numberOfRoom, Feature... features) {
        super(price, numberOfRoom, features);
    }


    public String getNameOfApartment(){
        return "Трехкомнатный номер";
    }
}
