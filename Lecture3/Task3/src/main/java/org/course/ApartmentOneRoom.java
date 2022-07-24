package org.course;

import java.util.List;

public class ApartmentOneRoom extends Apartment {
    private static final String APART_TYPE = "Однокомнатный номер";
    public ApartmentOneRoom(float price, int places, int roomNumber) {
        super(price, places, roomNumber);
    }
    @Override
    public String getApartmentsTypeName() {
        return APART_TYPE;
    }


}
