package org.course;

public class TwoRoomsApartment extends Apartment{

    public TwoRoomsApartment(int numberOfRoom, int price) {
        super(numberOfRoom, price);
    }

    public String getName(){
        return "Двухкомнатный номер";
    }

    public boolean setJacuzzi(boolean jacuzzi) {
        return false;
    }

}
