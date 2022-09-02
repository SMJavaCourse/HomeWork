package org.course;

import org.course.entity.Apartment;
import org.course.entity.Hotel;

import java.util.*;

public class SearchTimeDemo {

    public static void main(String[] args) {

        ArrayList<Apartment> apartment = new ArrayList<>();
        apartment.add(new Apartment(1, 11, 1000, 2, new ArrayList<>()));
        int numberOfHotels = 10_000_000;
        String nameOfHotelToFind = "имя отеля9999999";

        ArrayList<Hotel> hotelArrayList = new ArrayList<>();
        Map<String, Hotel> hotelByName = new HashMap<>();

        System.out.println("Начало создания отелей...");
        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfHotels; i++) {
            hotelArrayList.add(new Hotel("имя отеля" + i, "10:00", apartment));
            hotelByName.put(hotelArrayList.get(i).getName(),hotelArrayList.get(i));
        }
        long end = System.currentTimeMillis() - start;
        System.out.println(numberOfHotels + " отелей создано за " + end + " мс\n\nНачало поиска...\n");
        start = System.currentTimeMillis();
        Hotel findHotel = hotelByName.get(nameOfHotelToFind);
        end = System.currentTimeMillis() - start;
        System.out.println("Найдено отелей: 1\nВсего отелей: " + numberOfHotels + "\nНайдено за " + end + " мс.\n" + findHotel);

        start = System.currentTimeMillis();
        for (Hotel hotel:hotelArrayList){
            if (nameOfHotelToFind.equalsIgnoreCase(hotel.getName())){
                findHotel = hotel;
            }
        }
        end = System.currentTimeMillis() - start;
        System.out.println("Если искать перебором, то отель \"" + nameOfHotelToFind + "\" находится за " + end + " мс.");
    }
}
