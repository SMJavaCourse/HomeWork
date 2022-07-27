package org.course;

import org.course.exception.HotelFactoryException;
import org.course.constructors.HotelFactory;

import java.util.ArrayList;
import java.util.Scanner;

import static org.course.FindHelper.hotelFinderString;

public class Task3 {

    public static void main(String[] args) {

        System.out.println("");

        HotelFactory factory = HotelFactory.getInstance();
        ArrayList<Hotel> hotels = new ArrayList<>();
        try {
            hotels.add(factory.createHotel("У мамы лучше"));
            hotels.add(factory.createHotel("Шашлычок"));
            System.out.println(hotels.get(0).toString());
            System.out.println(hotels.get(1).toString());
        } catch (HotelFactoryException e) {
            System.out.println(e.getMessage() + "\nВыход из программы");
            System.exit(0);
        }

        System.out.println("======================= Поиск вободных номеров ========================\n" +
                "введите запрос в формате \"N\" или \"N \u00ABНазвание отеля\u00BB\", где N - количество гостей:");

        Scanner in = new Scanner((System.in));
        boolean exit = true;

        while (exit){
            String tryToFindSomeHotels = hotelFinderString(in.nextLine().trim(),hotels);
            if ("exit".equals(tryToFindSomeHotels)) {
                exit = false;
            } else {
                System.out.println(tryToFindSomeHotels);
            }
        }
    }
}
