package org.course;

public class OneRoomApartment extends Apartment {

    public OneRoomApartment(int numberOfRoom, int price) {
        super(numberOfRoom, price);
    }

    public String getName() {
        return "Однокомнатный номер";
    }

    public boolean setJacuzzi(boolean jacuzzi) {
        return false;
    }
}

