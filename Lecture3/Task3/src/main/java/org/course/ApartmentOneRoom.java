package org.course;

import java.util.List;

public class ApartmentOneRoom extends Apartment {
//    private boolean grillMeat;

    private static final String APART_TYPE = "Однокомнатный номер";
    public ApartmentOneRoom(float price, int places, int roomNumber, List<Services> servicesList) {
        super(price, places, roomNumber, servicesList);
    }
    @Override
    public String getApartmentsTypeName() {
        return APART_TYPE;
    }


}
