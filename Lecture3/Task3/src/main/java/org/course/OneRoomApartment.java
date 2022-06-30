package org.course;

import org.course.features.Feature;

public class OneRoomApartment extends Apartment {
    private static final int NUMBER_OF_ROOMS = 1;
    private static final String NAME_OF_APARTMENT = "Однокомнатный номер";

    public OneRoomApartment(double price, int numberOfRoom, Feature... features) {
        super(price, numberOfRoom, features);
    }
    public String getNameOfApartment(){
        return NAME_OF_APARTMENT;
    }

}
