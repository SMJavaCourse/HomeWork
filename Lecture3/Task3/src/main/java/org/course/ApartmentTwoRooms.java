package org.course;

import java.util.List;

public class ApartmentTwoRooms extends Apartment {
    private static final String APART_TYPE = "Двухкомнатный номер";
    public ApartmentTwoRooms(float price, int places, int roomNumber, List<Services> servicesList)
    {
        super(price, places, roomNumber, servicesList);
    }
    @Override
    public String getApartmentsTypeName() {
        return APART_TYPE;
    }

}
