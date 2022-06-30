package org.course;

import org.course.features.Feature;

public class TwoRoomApartment extends Apartment {
    private static final int NUMBER_OF_ROOMS = 2;

    public TwoRoomApartment(double price, int numberOfRoom, Feature... features) {
        super(price, numberOfRoom, features);
    }


    public String getNameOfApartment(){
        return "Двухкомнатный номер";
    }
}
