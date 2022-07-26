package org.course;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

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

    public static ArrayList findHotelNew(ArrayList<Hotel> hotels, String nameOfHotel) {

        ArrayList findHotelsResult = new ArrayList();

        for (int i = 0; i < hotels.size(); i++) {
            if (StringUtils.equalsIgnoreCase(nameOfHotel, hotels.get(i).getName())) {
                findHotelsResult.add(hotels.get(i));
                return findHotelsResult;
            }
        }
        return findHotelsResult;
    }

    public static ArrayList<Apartment> findApartmentNew(ArrayList<Apartment> apartments, int numberOfGuests) {
        ArrayList findApartmentsResult = new ArrayList();
        for (int j = 0; j < apartments.size(); j++) {
            if (numberOfGuests <= apartments.get(j).getCapacity()) {
                findApartmentsResult.add(apartments.get(j));
            }
        }
        if (findApartmentsResult.size() == 0) {
            return null;
        }
        return findApartmentsResult;
    }
}
