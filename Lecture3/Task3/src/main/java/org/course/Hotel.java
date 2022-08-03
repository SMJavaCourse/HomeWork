package org.course;

import java.time.LocalTime;
import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Apartment> apartments;
    private LocalTime checkInTime;
    private String[] allApartmentsInfo;

    public String getName() {
        return name;
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    public Hotel(String name, LocalTime checkInTime, ArrayList<Apartment> apartments) {
        this.name = name;
        this.checkInTime = checkInTime;
        this.apartments = apartments;
    }

    public String hotelInfo() {
        allApartmentsInfo = new String[apartments.size()];
        for (int i = 0; i < apartments.size(); i++) {
            allApartmentsInfo[i] = apartments.get(i).apartmentInfo();
        }
        return "Отель " + name + ":\nКоличество номеров: " + apartments.size() + "\nНомера:" + String.join("", allApartmentsInfo) + "\n";

    }
}