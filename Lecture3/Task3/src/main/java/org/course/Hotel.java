package org.course;

import lombok.Getter;

import java.util.*;

@Getter
public class Hotel {
    private final String name;
    private final List<Apartment> apartments;
    Map<Integer, List<Apartment>> apartmentByCapacity = new HashMap<>();
    private final String startTime;

    public Hotel(String name, String startTime, List<Apartment> apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;

        var apartLuxury = apartments
                .stream()
                .max(Comparator.comparing(Apartment::getPrice))
                .get();
        apartLuxury.isLuxury = true;

        for (Apartment apartment : this.getApartments()) {
            List<Apartment> apartsByCapacity = apartmentByCapacity.get(apartment.getCapacity());
            if (apartsByCapacity == null) {
                apartsByCapacity = new ArrayList<>();
                apartsByCapacity.add(apartment);
                apartmentByCapacity.put(apartment.getCapacity(), apartsByCapacity);
            } else {
                apartsByCapacity.add(apartment);
            }
        }
    }


//    public static Hotel search(String hotelsName, List<Hotel> hotels) {
//        for (Hotel hotel : hotels) {
//            String currentName = hotel.getName();
//            if (hotelsName.equalsIgnoreCase(currentName)) {
//                System.out.println("Для вас найден отель" + " " + "\n\"" + hotel.getName() + "\"\n");
//                return hotel;
//            }
//        }
//        return null;
//    }
    public static List<Hotel> searchByHotelName(String nameHotel, Map<String, List<Hotel>> hotelsByName){
        List<Hotel> hotelName = new ArrayList<>();
        for (Map.Entry<String, List<Hotel>> entry : hotelsByName.entrySet()) {
            String nameOfHotel = entry.getKey();
            if (nameOfHotel.equalsIgnoreCase(nameHotel)) {
                List<Hotel> hotelsNames = entry.getValue();
                hotelName.addAll(hotelsNames);
                System.out.println("Для вас найден отель" + " " + "\n\"" + nameOfHotel + "\"\n");
            }
        }
        return hotelName;
    }

    public static List<Apartment> searchRoom(int people, Map<Integer, List<Apartment>> apartsByCapacity) {
        if (people >= 0) {
            List<Apartment> roomList = new ArrayList<>();
            for (Map.Entry<Integer, List<Apartment>> entry : apartsByCapacity.entrySet()) {
                int apartCapacity = entry.getKey();
                if (people <= apartCapacity) {
                    List<Apartment> aparts = entry.getValue();
                    roomList.addAll(aparts);
                }
            }
            return roomList;
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
