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

    public void setApartments(ArrayList<Apartment> apartments) {
        this.apartments = apartments;
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

    public static ArrayList<Hotel> findHotelsNew(ArrayList<Hotel> hotels, String nameOfHotel, int numberOfGuests) {
        ArrayList<Hotel> findHotelsResult = new ArrayList<>();
        ArrayList<Apartment> findApartmentsResult = new ArrayList<>();
        int numberOfFindApartments = 0;

        if (nameOfHotel == null) {
            for (Hotel hotel : hotels) {
                int j = 0;
                while (j < hotel.getApartments().size()) {
                    if (numberOfGuests <= hotel.getApartments().get(j).getCapacity()) {
                        findApartmentsResult.add(hotel.getApartments().get(j));
                        numberOfFindApartments += 1;
                    }
                    j++;
                }
                if (numberOfFindApartments >= 1) {
                    findHotelsResult.add(hotel);
                }
                if (findHotelsResult.size() > 0) {
                    findHotelsResult.get(findHotelsResult.size() - 1).setApartments(findApartmentsResult);
                }
            }
        } else {
            for (Hotel hotel : hotels) {
                if (nameOfHotel.equals(hotel.getName())) {
                    int j = 0;
                    while (j < hotel.getApartments().size()) {
                        if (numberOfGuests <= hotel.getApartments().get(j).getCapacity()) {
                            findApartmentsResult.add(hotel.getApartments().get(j));
                            numberOfFindApartments += 1;
                        }
                        j++;
                    }
                    if (numberOfFindApartments != 0) {
                        findHotelsResult.add(hotel);
                    }
                    if (findHotelsResult.size() > 0) {
                        findHotelsResult.get(findHotelsResult.size() - 1).setApartments(findApartmentsResult);
                    }
                }
            }
        }
        return findHotelsResult;
    }

    public static ArrayList<Hotel> findHotel(ArrayList<Hotel> hotels, String nameOfHotel) {
        ArrayList<Hotel> findHotelsResult = new ArrayList<>();
        for (int i = 0; i < hotels.size(); i++) {
            if (nameOfHotel.equalsIgnoreCase(hotels.get(i).getName())) {
                findHotelsResult.add(hotels.get(i));
                return findHotelsResult;
            }
        }
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
