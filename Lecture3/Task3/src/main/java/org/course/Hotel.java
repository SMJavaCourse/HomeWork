package org.course;

public class Hotel {
    private String name;
    private Apartment[] apartments;
    private static String checkInTime;

    public static String getCheckInTime() {
        return checkInTime;
    }

    public Hotel(String name, String checkInTime, Apartment[] apartments) {
        this.name = name;
        Hotel.checkInTime = checkInTime;
        this.apartments = apartments;
    }

    void HotelInfo() {
        System.out.println("Отель " + name + ":\nКоличество номеров: " + apartments.length + "\nНомера:");
        for (int i = 0; i < apartments.length; i++) {
            apartments[i].ApartmentInfo();
        }
        System.out.println();
    }
}