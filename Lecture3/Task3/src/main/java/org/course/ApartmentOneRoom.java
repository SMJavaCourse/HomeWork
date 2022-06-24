package main.java.org.course;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ApartmentOneRoom extends Apartment {
    private boolean grillMeat;
    private static final String APART_TYPE = "Однокомнатный номер";

    public ApartmentOneRoom(float price, int places, int roomNumber) {
        super(price, places, roomNumber);
    }

    @Override
    public String getApartmentsTypeName() {
        return APART_TYPE;
    }

}
