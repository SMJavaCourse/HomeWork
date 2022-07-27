package org.course;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final String name;
    private final List<Apartment> apartments;
    private String startTime;

    public Hotel(String name, String startTime, List<Apartment> apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;
    }


    public String getName() {
        return name;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public static Hotel search(String hotelsName, List<Hotel> hotels) {
        for (Hotel hotel : hotels) {
            String currentName = hotel.getName();
            if (hotelsName.equalsIgnoreCase(currentName)) {
                System.out.println("Для вас найден отель" + " " + "\n\"" + hotel.getName() + "\"\n");
                return hotel;
            }
        }
        return null;
    }

    public List<Apartment> searchRoom(int people) {
        if (people >= 0) {
            List<Apartment> foundRooms = new ArrayList<>();
            for (int i = 0; i < this.getApartments().size(); i++) {
                Apartment apartment = this.getApartments().get(i);
                if (people <= apartment.getCapacity()) {
                    foundRooms.add(apartment);
                }
            }
            return foundRooms;
        }
        return null;
    }


    public static void printApartments(List<Apartment> apartments) {
        System.out.println("Количество найденных аппартаментов: " + apartments.size() + "\n");
        for (Apartment apartment : apartments) {
            apartment.print();
        }
    }
}
