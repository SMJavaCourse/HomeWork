package org.course;

import org.course.exception.HotelFactoryException;
import org.course.constructors.HotelFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

import static org.course.Hotel.findHotel;
import static org.course.Hotel.findApartment;

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
        boolean exit = false;

        while (!exit) {
            String input = in.nextLine().trim();
            String finderHotelString = "";
            if (StringUtils.isBlank(input)) {
                System.out.println("Пустая строка. Повторите ввод");
                continue;
            }
            if ("exit".equalsIgnoreCase(input) || "выход".equalsIgnoreCase(input)) {
                exit = true;
            } else {
                int firstSpaceIndex = input.trim().indexOf(" ");
                int numberOfHotelsFound = 0;
                try {
                    if (firstSpaceIndex == -1) {
                        int numberOfGuests = Integer.parseInt(input.trim());
                        if (numberOfGuests < 1) {
                            System.out.println("Количество гостей не может быть меньше 1, повторите ввод:");
                            continue;
                        }
                        for (Hotel hotel : hotels) {
                            ArrayList<Apartment> findApartments = findApartment(hotel.getApartments(), numberOfGuests);
                            finderHotelString += "Отель \"" + hotel.getName() + "\":\nПодходящих номеров: " +
                                    findApartments.size() + "\nНомера:\n";
                            for (Apartment findApartment : findApartments) {
                                finderHotelString += findApartment.toString();
                            }
                            numberOfHotelsFound += 1;
                        }
                        System.out.println("Найдено отелей: " + numberOfHotelsFound + "\n" + finderHotelString + "\nНовый поиск:");
                        continue;
                    }
                    int numberOfGuests = Integer.parseInt(input.substring(0, firstSpaceIndex));
                    if (numberOfGuests < 1) {
                        System.out.println("Количество гостей не может быть меньше 1, повторите ввод:");
                        continue;
                    }
                    ArrayList<Hotel> searchResult = findHotel(hotels, input.substring(firstSpaceIndex + 1));
                    if (searchResult.size() != 0) {
                        for (Hotel hotel : searchResult) {
                            ArrayList<Apartment> findApartments = findApartment(hotel.getApartments(), Integer.parseInt(input.substring(0, firstSpaceIndex)));
                            finderHotelString += "Отель \"" + hotel.getName() + "\":\nПодходящих номеров: " + findApartments.size() + "\nНомера:\n";
                            for (Apartment apartment: findApartments){
                                finderHotelString += apartment.toString();
                            }
                        }
                    } else {
                        System.out.println("У нас нет информации по отелю " + input.substring(firstSpaceIndex + 1));
                    }
                    if ("".equals(finderHotelString)) {
                        System.out.println("В отеле \"" + input.substring(firstSpaceIndex + 1) + "\" нет достаточного количества мест\nНовый поиск:");
                    } else {
                        System.out.println("Найдено отелей: " + numberOfHotelsFound + "\n" + finderHotelString + "\nНовый поиск:");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Количество гостей это число, повторите ввод:");
                }
            }
        }
    }
}
