package org.course;

import org.course.repository.HotelRepository;
import org.course.entity.Hotel;

import java.util.UUID;

public class SearchTimeDemo {

    public static void main(String[] args) {

        HotelRepository hotelRepository = new HotelRepository();
        var ttt = hotelRepository.deleteById("11");


        int numberOfHotels = 1000;
        String nameOfHotelToFind = "имя отеля999";

        System.out.println("Начало создания отелей...");

        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfHotels; i++) {
            var tempHotel = hotelRepository.save(new Hotel(UUID.randomUUID().toString(), "имя отеля" + i, "10:00"));
        }
        long end = System.currentTimeMillis() - start;
        System.out.println(numberOfHotels + " отелей создано за " + end + " мс\n\nНачало поиска...\n");

        start = System.currentTimeMillis();
        String findHotel = hotelRepository.hotelFinder(nameOfHotelToFind, null, 1);
        end = System.currentTimeMillis() - start;
        System.out.println("Найдено отелей: 1\nВсего отелей: " + numberOfHotels + "\nНайдено за " + end + " мс.\n" + findHotel + "\nвыход");


    }
}
