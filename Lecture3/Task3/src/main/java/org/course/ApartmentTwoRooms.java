package org.course;

import java.util.List;

public class ApartmentTwoRooms extends Apartment {
    private static final String APART_TYPE = "Двухкомнатный номер";
    public ApartmentTwoRooms(float price, int places, int roomNumber)
    {
        super(price, places, roomNumber);
    }
    @Override
    public String getApartmentsTypeName() {
        return APART_TYPE;
    }

}