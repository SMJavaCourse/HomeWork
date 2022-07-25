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

    public void print() {
        System.out.println("Отель: " + name);
        System.out.println("Количество номеров: " + apartments.length);
        System.out.println("Номера:");
        for (int i = 0; i < apartments.length; i++)
            apartments[i].print();
    }

    public static Hotel search(String hotelsName, Hotel[] hotels) {
        for (int i = 0; i < hotels.length; i++) {
            Hotel hotel = hotels[i];
            String currentName = hotel.getName();
            if (hotelsName.equalsIgnoreCase(currentName)) {
                System.out.println("Для вас найден отель" + " " + "\n\"" + hotel.getName() + "\"\n");
                return hotel;
            }
        }
        return null;
    }

    public static Apartment[] searchRoom(int people, Hotel hotel) {
        if (people <= 0) {
            System.out.println("Введенное количество гостей должно быть больше нуля");
        }
        if (people > 0) {
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
                System.out.println("Подходящих номеров не найдено");
            }
            Apartment[] result = Arrays.copyOf(foundRoom, numberOfMatches);
            return result;
        }
        return null;
    }

    public static void printApartments(Apartment[] apartments) {
        System.out.println("Количество найденных аппартаментов: " + apartments.length);
        for (int i = 0; i < apartments.length; i++) {
            apartments[i].print();
        }
    }
}
