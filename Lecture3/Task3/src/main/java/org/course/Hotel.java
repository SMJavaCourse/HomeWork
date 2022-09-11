package org.course;

import java.util.*;

public class Hotel {
    private final String name;
    private final List<Apartment> apartments;
    private Map<Amenity, List<Apartment>> apartmentListByAmenity;
    private final String checkInTime;

    public Hotel(String name, String checkInTime, List<Apartment> apartments) {
        this.name = name;
        this.apartments = apartments;
        this.checkInTime = checkInTime;
        // сюда добавить заполнение мапы. мапа листов о.О
    }

    public String getName() {
        return name;
    }

    private List<Apartment> getApartments() {
        return apartments;
    }

    public static Map<String, Hotel> toHotelsByNameMap(List<Hotel> hotels) {
        Map<String, Hotel> hotelsByName = new HashMap<>();
        for (Hotel hotel : hotels) {
            hotelsByName.put(hotel.name.toLowerCase(), hotel);
        }
        return hotelsByName;
    }

    public static Hotel search(String hotelsName, Map<String, Hotel> hotelByName) {
        return hotelByName.get(hotelsName.toLowerCase());
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
        System.out.println("Количество найденных апартаментов: " + apartments.size() + "\n");
        for (Apartment apartment : apartments) {
            apartment.print();
        }
    }
}
