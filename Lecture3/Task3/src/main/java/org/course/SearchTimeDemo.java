package org.course;

import org.course.services.Services;

import java.util.ArrayList;
import static org.course.Hotel.findHotel;

public class SearchTimeDemo {

    public static void main(String[] args) {

        ArrayList<Apartment> apartment = new ArrayList<>();
        apartment.add(new Apartment(1, 11, 1000, 2, new ArrayList<Services>()));
        int numberOfHotels = 10_000_000;
        String nameOfHotelToFind = "имя отеля9999999";

        ArrayList<Hotel> hotelArrayList = new ArrayList<>();

        System.out.println("Начало создания отелей...");
        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfHotels; i++) {
            hotelArrayList.add(new Hotel("имя отеля" + i, "10:00", apartment));
        }
        long end = System.currentTimeMillis() - start;
        System.out.println(numberOfHotels + " отелей создано за " + end + " мс\n");
        System.out.println("Начало поиска...");
        start = System.currentTimeMillis();
        ArrayList<Hotel> findHotelIs = findHotel(hotelArrayList, nameOfHotelToFind);
        end = System.currentTimeMillis() - start;
        System.out.println("Отель \"" + nameOfHotelToFind + "\" нашли за " + end + " мс.\n\nПараметры найденного отеля:\n" + findHotelIs);
    }
}
