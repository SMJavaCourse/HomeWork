package org.course;

import java.time.LocalTime;

public class Hotel {
    private String name;
    private Apartment[] apartments;
    private LocalTime checkInTime;
    private String[] allApartmentsInfo;

    public String getName() {
        return name;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public Hotel(String name, LocalTime checkInTime, Apartment[] apartments) {
        this.name = name;
        this.checkInTime = checkInTime;
        this.apartments = apartments;
    }

    public String hotelInfo() {
        allApartmentsInfo = new String[apartments.length];
        for (int i = 0; i < apartments.length; i++) {
            allApartmentsInfo[i] = apartments[i].apartmentInfo();
        }
        return "Отель " + name + ":\nКоличество номеров: " + apartments.length + "\nНомера:" + String.join("", allApartmentsInfo) + "\n";

    }
}