package org.course;

import java.util.List;

public class ApartmentThreeRooms extends Apartment {
    private static final String APART_TYPE = "Трехкомнатный номер";
    public ApartmentThreeRooms(float price, int places, int roomNumber, List<Services> servicesList) {
        super(price, places, roomNumber, servicesList);
    }
    @Override
    public String getApartmentsTypeName() {
        return APART_TYPE;
    }

}
