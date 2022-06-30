package org.course;

public class ThreeRoomsApartment extends Apartment{

    public ThreeRoomsApartment(int numberOfRoom, int price) {
        super(numberOfRoom, price);
    }

    public String getName(){
        return "Трёхкомнатный номер";
    }
}