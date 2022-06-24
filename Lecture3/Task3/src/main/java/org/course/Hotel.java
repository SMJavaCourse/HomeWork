package main.java.org.course;

import java.time.LocalTime;

public class Hotel implements Hotels{
    private String name;
    private LocalTime checkInTime;
    private Apartment[] apartments;
    private int roomsTotalCount;

    public Hotel(String name, Apartment[] apartments, LocalTime checkInTime) {
        this.name = name;
        this.apartments = apartments;
        this.checkInTime = checkInTime;
        this.roomsTotalCount = getRoomsTotalCount() + apartments.length;

        for (int i = 0; i < apartments.length; i++) {
            apartments[i].setCheckinTime(checkInTime);
        }

    }

    @Override
    public String toString() {
        return "Отель \"" + this.name + "\":\n" +
                "Количество номеров: " + this.roomsTotalCount + "\n" +
                "Номера: ";
    }

    public Apartment[] getAllApartments() {
        return apartments;
    }
    public int getRoomsTotalCount() {
        return roomsTotalCount;
    }

}
