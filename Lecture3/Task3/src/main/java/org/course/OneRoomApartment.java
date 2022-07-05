package org.course;

import org.course.services.Services;

public class OneRoomApartment extends Apartment {

    public OneRoomApartment(int numberOfRoom, int price, Services... services) {
        super(numberOfRoom, price, services);
    }

    public String getName() {
        return "Однокомнатный номер";
    }

}

