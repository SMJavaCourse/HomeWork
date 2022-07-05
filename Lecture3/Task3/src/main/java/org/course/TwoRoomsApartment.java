package org.course;

import org.course.services.Services;

public class TwoRoomsApartment extends Apartment{

    public TwoRoomsApartment(int numberOfRoom, int price, Services... services) {
        super(numberOfRoom, price, services);
    }

    public String getName(){
        return "Двухкомнатный номер";
    }

}
