package org.course;

import org.course.exception.HotelFactoryException;
import org.course.constructors.HotelFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

import static org.course.Hotel.findHotelNew;
import static org.course.Hotel.findApartmentNew;

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

        while (!exit) {
            String input = in.nextLine().trim();
            String vivod = "";
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
                        for (int i = 0; i < hotels.size(); i++) {
                            ArrayList<Apartment> findApartments = findApartmentNew(hotels.get(i).getApartments(), numberOfGuests);
                            if (findApartments != null) {
                                vivod += "Отель \"" + hotels.get(i).getName() + "\":\nПодходящих номеров: " + findApartments.size() + "\nНомера:\n" + findApartments.toString() + "\n";
                                numberOfHotelsFound += 1;
                            }
                        }
                        System.out.println("Найдено отелей: " + numberOfHotelsFound + "\n" + vivod + "\nНовый поиск:");
                        continue;
                    }
                    int numberOfGuests = Integer.parseInt(input.substring(0, firstSpaceIndex));
                    if (numberOfGuests < 1) {
                        System.out.println("Количество гостей не может быть меньше 1, повторите ввод:");
                        continue;
                    }
                    ArrayList<Hotel> searchResult = findHotelNew(hotels, input.substring(firstSpaceIndex + 1));
                    if (searchResult.size() != 0) {
                        for (int i = 0; i < searchResult.size(); i++) {
                            ArrayList<Apartment> findApartments = findApartmentNew(searchResult.get(i).getApartments(), Integer.parseInt(input.substring(0, firstSpaceIndex)));
                            if (findApartments != null) {
                                vivod += "Отель \"" + searchResult.get(i).getName() + "\":\nПодходящих номеров: " + findApartments.size() + "\nНомера:\n" + findApartments;
                                numberOfHotelsFound += 1;
                            }
                        }
                    } else {
                        System.out.println("У нас нет информации по отелю " + input.substring(firstSpaceIndex + 1));
                    }
                    if (vivod == "") {
                        System.out.println("В отеле \"" + input.substring(firstSpaceIndex + 1) + "\" нет достаточного количества мест\nНовый поиск:");
                    } else {
                        System.out.println("Найдено отелей2: " + numberOfHotelsFound + "\n" + vivod + "\nНовый поиск:");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Количество гостей это число, повторите ввод:");
                }
            }
        }
    }
}
