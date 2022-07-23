package org.course;

import org.course.exception.HotelFactoryException;
import org.course.constructors.HotelFactory;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import static org.course.Hotel.findHotel;
import static org.course.Hotel.findHotelNew;

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
        } catch (NullPointerException e) {
            System.out.println("Отели не созданы, нечего выводить." + "\nВыход из программы");
            System.exit(0);
        }

        System.out.println("======================= Поиск вободных номеров ========================\n" +
                "введите запрос в формате \"N\" или \"N \u00ABНазвание отеля\u00BB\", где N - количество гостей:");

        Scanner in = new Scanner((System.in));
        boolean exit = false;

//        while (!exit) {
//            String input = in.nextLine().trim();
//            if (StringUtils.isBlank(input)) {
//                System.out.println("Пустая строка. Повторите ввод");
//                continue;
//            }
//            if ("exit".equalsIgnoreCase(input) || "выход".equalsIgnoreCase(input)) {
//                exit = true;
//            } else {
//                int firstSpaceIndex = input.trim().indexOf(" ");
//                try {
//                    if (firstSpaceIndex == -1) {
//                        ArrayList<Hotel> searchResult = findHotelNew(hotels, null, Integer.parseInt(input.trim()));
//                        for (int i = 0; i < searchResult.size(); i++) {
//                            System.out.println(searchResult.get(i));
//                        }
//
////                        System.out.println(findHotelNew(hotels, null,Integer.parseInt(input.trim())) + "\nЕщё один поиск:");
//                        continue;
//                    }
//                    int numberOfGuests = Integer.parseInt(input.substring(0, firstSpaceIndex));
//                    System.out.println(findHotelNew(hotels, input.substring(firstSpaceIndex+1), numberOfGuests) + "\nПовторите ввод:");
//                } catch (NumberFormatException e) {
//                    System.out.println("Количество гостей это число, повторите ввод:");
//                }
//            }
//        }
        while (!exit) {
            String input = in.nextLine().trim();
            if (StringUtils.isBlank(input)) {
                System.out.println("Пустая строка. Повторите ввод");
                continue;
            }
            if ("exit".equalsIgnoreCase(input) || "выход".equalsIgnoreCase(input)) {
                exit = true;
            } else {
                int firstSpaceIndex = input.trim().indexOf(" ");
                try {
                    if (firstSpaceIndex == -1) {
                        System.out.println(findHotel(hotels, null,Integer.parseInt(input.trim())) + "\nЕщё один поиск:");
                        continue;
                    }
                    int numberOfGuests = Integer.parseInt(input.substring(0, firstSpaceIndex));
                    System.out.println(findHotel(hotels, input.substring(firstSpaceIndex+1), numberOfGuests) + "\nПовторите ввод:");
                } catch (NumberFormatException e) {
                    System.out.println("Количество гостей это число, повторите ввод:");
                }
            }
        }
    }
}
