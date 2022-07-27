package org.course;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import static org.course.Hotel.findApartment;
import static org.course.Hotel.findHotel;

public class FindHelper {

    public static String hotelFinderString(String input, ArrayList<Hotel> hotels) {

        String finderHotelString = "";
        if (StringUtils.isBlank(input)) {
            return "Пустая строка. Повторите ввод";
        }
        if ("exit".equalsIgnoreCase(input) || "выход".equalsIgnoreCase(input)) {
            return "exit";
        } else {
            int firstSpaceIndex = input.trim().indexOf(" ");
            int numberOfHotelsFound = 0;
            try {
                if (firstSpaceIndex == -1) {
                    int numberOfGuests = Integer.parseInt(input.trim());
                    if (numberOfGuests < 1) {
                        return "Количество гостей не может быть меньше 1, повторите ввод:";
                    }
                    for (Hotel hotel : hotels) {
                        ArrayList<Apartment> findApartments = findApartment(hotel.getApartments(), numberOfGuests);
                        if (findApartments.size() == 0) {
                            continue;
                        }
                        finderHotelString += "Отель \"" + hotel.getName() + "\":\nПодходящих номеров: " +
                                findApartments.size() + "\nНомера:\n";
                        for (Apartment findApartment : findApartments) {
                            finderHotelString += findApartment.toString();
                        }
                        numberOfHotelsFound += 1;
                    }
                    return "Найдено отелей: " + numberOfHotelsFound + "\n" + finderHotelString + "\nНовый поиск:";
                }
                int numberOfGuests = Integer.parseInt(input.substring(0, firstSpaceIndex));
                if (numberOfGuests < 1) {
                    return "Количество гостей не может быть меньше 1, повторите ввод:";
                }
                ArrayList<Hotel> searchResult = findHotel(hotels, input.substring(firstSpaceIndex + 1));
                if (searchResult.size() != 0) {
                    for (Hotel hotel : searchResult) {
                        ArrayList<Apartment> findApartments = findApartment(hotel.getApartments(), Integer.parseInt(input.substring(0, firstSpaceIndex)));
                        if (findApartments.size() > 0) {
                            finderHotelString += "Отель \"" + hotel.getName() + "\":\nПодходящих номеров: " + findApartments.size() + "\nНомера:\n";
                            for (Apartment apartment : findApartments) {
                                finderHotelString += apartment.toString();
                            }
                        }
                    }
                } else {
                    return "У нас нет информации по отелю \"" + input.substring(firstSpaceIndex + 1) + "\"";
                }
                if ("".equals(finderHotelString)) {
                    return "В отеле \"" + input.substring(firstSpaceIndex + 1) + "\" нет достаточного количества мест\nНовый поиск:";
                } else {
                    return "Найдено отелей: " + numberOfHotelsFound + "\n" + finderHotelString + "\nНовый поиск:";
                }
            } catch (NumberFormatException e) {
                return "Количество гостей это число, повторите ввод:";
            }
        }
    }
}
