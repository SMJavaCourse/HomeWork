package org.course;

import java.util.Arrays;

public class Hotel {
    private String name;
    private Apartment[] apartments;
    private String startTime;

    public Hotel(String name, String startTime, Apartment[] apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;
    }


    public String getName() {
        return name;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void print(){
        System.out.println("Отель: " + name);
        System.out.println("Количество номеров: " + apartments.length);
        System.out.println("Номера:");
        for (int i =0; i< apartments.length; i++)
            apartments[i].print();
        }

    public static Hotel search (String name, Hotel[] hotels) {
        for (int i = 0; i < hotels.length; i++) {
            Hotel hotel = hotels[i];
            String currentName = hotel.getName();
            if (name.equalsIgnoreCase(currentName)) {
                return hotel;
            }
        }
        return null;
    }
    public static Apartment[] searchRoom(int people, Hotel hotel) {
        int numberOfMatches = 0;
        Apartment[] foundRoom = new Apartment[hotel.getApartments().length];
        for (int i = 0; i < hotel.getApartments().length; i++) {
            Apartment apartment = hotel.getApartments()[i];
            if (people <= apartment.getCapacity()) {
                foundRoom[numberOfMatches] = apartment;
                numberOfMatches += 1;
            }
        }
        if (numberOfMatches == 0) {
            return null;
        }
        Apartment[] result = Arrays.copyOf(foundRoom, numberOfMatches);
        return result;
    }
}