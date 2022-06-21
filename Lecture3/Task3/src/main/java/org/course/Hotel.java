package main.java.org.course;

import java.time.LocalTime;

public class Hotel {
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

    public static void printHotelInfo(Hotel[] hotels) {
        for (int i = 0; i < hotels.length; i++) {
            System.out.println(hotels[i].toString());
            Apartment.printAparts(hotels[i].getApartments());
            System.out.println("\n************************************************\n");
        }
    }


    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public Hotel setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
        return this;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public Hotel setApartments(Apartment[] apartments) {
        this.apartments = apartments;
        return this;
    }

    public int getRoomsTotalCount() {
        return roomsTotalCount;
    }

    public Hotel setRoomsTotalCount(int roomsTotalCount) {
        this.roomsTotalCount = roomsTotalCount;
        return this;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

}
