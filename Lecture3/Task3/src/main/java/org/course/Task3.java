package org.course;

import org.course.additions.*;
import org.course.apartments.OneRoomApartment;
import org.course.apartments.ThreeRoomsApartment;
import org.course.apartments.TwoRoomsApartment;
import org.course.searh.SearchEngine;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Addition[] additions;
        Balcony balcony = new Balcony();
        Cleaning cleaning = new Cleaning();
        Internet internet = new Internet();
        AirConditioner airConditioner = new AirConditioner();
        Kebab kebab = new Kebab();
        ArrayList<Hotel> hotels = new ArrayList<>();

//          Данные отеля "У мамы лучше".
        ArrayList<Apartment> apartmentsMomHotel = new ArrayList<>();
        hotels.add(new Hotel("\"У мамы лучше\"", LocalTime.of(12, 0), apartmentsMomHotel));

        additions = new Addition[]{balcony};
        apartmentsMomHotel.add(new OneRoomApartment(1500, 2, 13, additions, LocalTime.of(12, 0)));

        additions = new Addition[]{balcony, cleaning, internet, airConditioner};
        apartmentsMomHotel.add(new TwoRoomsApartment(3000, 4, 14, additions, LocalTime.of(12, 0)));

        additions = new Addition[]{balcony, cleaning, internet, airConditioner};
        apartmentsMomHotel.add(new TwoRoomsApartment(3000, 4, 15, additions, LocalTime.of(12, 0)));

        apartmentsMomHotel.add(new ThreeRoomsApartment(2500, 6, 16, null, LocalTime.of(12, 0)));

        additions = new Addition[]{balcony, internet};
        apartmentsMomHotel.add(new ThreeRoomsApartment(3500, 6, 17, additions, LocalTime.of(12, 0)));

//          Данные отеля "Шашлычок".
        ArrayList<Apartment> apartmentsKebabHotel = new ArrayList<>();
        hotels.add(new Hotel("\"Шашлычок\"", LocalTime.of(9, 0), apartmentsKebabHotel));

        additions = new Addition[]{kebab};
        apartmentsKebabHotel.add(new OneRoomApartment(1000, 2, 10, additions, LocalTime.of(9, 0)));

        additions = new Addition[]{balcony, cleaning};
        apartmentsKebabHotel.add(new TwoRoomsApartment(2000, 4, 11, additions, LocalTime.of(9, 0)));

        additions = new Addition[]{cleaning};
        apartmentsKebabHotel.add(new ThreeRoomsApartment(4000, 6, 12, additions, LocalTime.of(9, 0)));

//          Поиск апартаментов по названию отеля и вместимости.
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        boolean list = false;
        while (!list && !exit) {
            System.out.print("Введите количество человек и/или название отеля через запятую (\"list\" - полный список; \"exit\" - завершить): ");
            String query = in.nextLine();
            if (query == null || query.equals("")) {
                continue;
            } else if ("list".equalsIgnoreCase(query.trim())) {
                list = true;
            } else if ("exit".equalsIgnoreCase(query.trim())) {
                exit = true;
            } else {
                SearchEngine searchEngine = new SearchEngine(query, hotels);
                System.out.println(searchEngine.search());
            }
        }
        in.close();

//          Вывод всех апартаментов в консоль.
        if (list) {
            System.out.println("Список всех отелей и номеров:");
            for (Hotel hotel : hotels) {
                System.out.println(hotel.hotelInfo());
            }
        }
    }
}