package org.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hotel {
    private String name;
    private ArrayList<Apartment> apartments;
    private String startTime;

    public Hotel(String name, String startTime, ArrayList<Apartment> apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    @Override
    public String toString() throws NullPointerException {
        StringBuilder text = new StringBuilder("Отель \"" + name + "\"\nКоличество номеров: " + apartments.size() +
                "\nВремя заселение/выселения: " + startTime + "\nНомера:\n");
        for (Apartment apartment : apartments) {
            text.append(apartment.toString());
        }
        return text.toString();
    }

    public static ArrayList<Hotel> findHotel(ArrayList<Hotel> hotels, String nameOfHotel) {
        ArrayList<Hotel> findHotelsResult = new ArrayList<>();
        if (nameOfHotel == null) {
            findHotelsResult = (ArrayList<Hotel>) hotels.clone();
        } else {
            for (Hotel hotel : hotels) {
                if (nameOfHotel.equalsIgnoreCase(hotel.getName())) {
                    findHotelsResult.add(hotel);
                }
            }
        }
        Collections.sort(findHotelsResult, Comparator.comparing(Hotel::getName));
        return findHotelsResult;
    }

    public static ArrayList<Apartment> findApartment(ArrayList<Apartment> apartments, int numberOfGuests) {
        ArrayList<Apartment> findApartmentsResult = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (numberOfGuests <= apartment.getCapacity()) {
                findApartmentsResult.add(apartment);
            }
        }
        return findApartmentsResult;
    }
}
