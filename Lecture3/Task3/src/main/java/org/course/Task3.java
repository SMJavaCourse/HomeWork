package org.course;

import org.course.exception.HotelFactoryException;
import org.course.utils.HotelFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.course.utils.FindHelper.hotelFinderString;
import static org.course.utils.ScannerCheck.validator;

public class Task3 {

    private static Map<String, Hotel> hotelByName = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("");

        HotelFactory factory = HotelFactory.getInstance();
        ArrayList<Hotel> hotels = new ArrayList<>();
        Map<String, Hotel> hotelStreamByName;

        try {
            hotels.add(factory.createHotel("У мамы лучше"));
            hotels.add(factory.createHotel("Шашлычок"));
            for (Hotel hotel : hotels) {
                System.out.println(hotel.toString());
            }
        } catch (HotelFactoryException e) {
            System.out.println(e.getMessage() + "\nВыход из программы");
            System.exit(0);
        }

        hotelStreamByName = hotels.stream().collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity()));

        System.out.println("======================= Поиск вободных номеров ========================\n" +
                "введите запрос в формате \"N\" или \"N \u00ABНазвание отеля\u00BB\", где N - количество гостей:");

        Scanner in = new Scanner((System.in));
        boolean exit = true;

        while (exit) {
            ArrayList validateInput = validator(in.nextLine().trim());
            if (validateInput.size() == 1) {
                if ("exit".equals(validateInput.get(0))) {
                    exit = false;
                } else {
                    System.out.println(validateInput.get(0));
                }
            } else {
                System.out.println(hotelFinderString(validateInput, hotelStreamByName));
            }
        }

        in.close();
    }
}
