package org.course;

import lombok.Getter;
import java.util.*;

@Getter
public class Hotel {
    private final String name;
    private final List<Apartment> apartments;
    private String startTime;

    public Hotel(String name, String startTime, List<Apartment> apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;

        var apartLuxury = apartments
                .stream()
                .max(Comparator.comparing(Apartment::getPrice))
                .get();
        apartLuxury.setName(" LUXURY");
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

//    public static Hotel hotelNameToMap(List<Hotel> hotels) {
//        HashMap<String, Hotel> hotelName = new HashMap<>();
//        for (Hotel hotel : hotels) {
//            hotelName.put(hotel.name.toLowerCase(), hotel);
//        }
//        return ;
//    }

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
