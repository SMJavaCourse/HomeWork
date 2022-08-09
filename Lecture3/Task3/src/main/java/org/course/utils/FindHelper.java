package org.course.utils;

import org.apache.commons.lang3.StringUtils;
import org.course.Apartment;
import org.course.Hotel;

import java.util.*;

import static org.course.Hotel.findApartment;
import static org.course.Hotel.printServices;

public class FindHelper {

    public static String hotelFinderString(String input, Map<String, Hotel> hotelByName) {

        String finderHotelString = "";
        if (StringUtils.isBlank(input)) {
            return "Пустая строка. Повторите ввод";
        }
        if ("exit".equalsIgnoreCase(input) || "выход".equalsIgnoreCase(input)) {
            return "exit";
        } else {
            int firstSpaceIndex = input.trim().indexOf(" ");
            int numberOfHotelsFound = 0;
            int numberOfGuests;
            String nameOfHotel;
            String nameOfCommand;

            if (firstSpaceIndex == -1) {
                if (isNumber(input.trim())) {
                    numberOfGuests = Integer.parseInt(input.trim());
                    nameOfHotel = null;
                    if (numberOfGuests < 1) {
                        return "Количество гостей не может быть меньше 1, повторите ввод:";
                    }
                } else {
                    return "Количество гостей это число, повторите ввод:";
                }
            } else {
                if (isNumber(input.substring(0, firstSpaceIndex))) {
                    numberOfGuests = Integer.parseInt(input.substring(0, firstSpaceIndex));
                    nameOfHotel = input.substring(firstSpaceIndex + 1);
                    if (numberOfGuests < 1) {
                        return "Количество гостей не может быть меньше 1, повторите ввод:";
                    }
                } else {
                    nameOfHotel = input.substring(firstSpaceIndex + 1);
                    nameOfCommand = input.substring(0, firstSpaceIndex);
                    ArrayList<Hotel> searchResult = findHotel(nameOfHotel, hotelByName);
                    if (searchResult.size() != 0) {
                        if ("удобства".equalsIgnoreCase(nameOfCommand)) {
                            finderHotelString += "Отель \"" + nameOfHotel + "\"\n" + printServices(searchResult.get(0).getApartments());
                        }
                        return finderHotelString;
                    } else {
                        return "У нас нет информации по отелю \"" + nameOfHotel + "\"\nНовый поиск:";
                    }
                }
            }
            ArrayList<Hotel> searchResult = findHotel(nameOfHotel, hotelByName);
            if (searchResult.size() != 0) {
                for (Hotel hotel : searchResult) {
                    ArrayList<Apartment> findApartments = findApartment(hotel.getApartments(), numberOfGuests);
                    if (findApartments.size() > 0) {
                        finderHotelString += "Отель \"" + hotel.getName() + "\":\nПодходящих номеров: " +
                                findApartments.size() + "\nНомера:\n";
                        for (Apartment apartment : findApartments) {
                            finderHotelString += apartment.toString();
                        }
                        numberOfHotelsFound += 1;
                    }
                }
            } else {
                return "У нас нет информации по отелю \"" + nameOfHotel + "\"\nНовый поиск:";
            }
            if (("".equals(finderHotelString) && nameOfHotel == null) || !finderHotelString.equals("")) {
                return "Найдено отелей: " + numberOfHotelsFound + "\n" + finderHotelString + "\nНовый поиск:";
            } else {
                return "В отеле \"" + nameOfHotel + "\" нет достаточного количества мест\nНовый поиск:";
            }
        }
    }

    private static ArrayList<Hotel> findHotel(String nameOfHotel, Map<String, Hotel> hotelByName) {
        ArrayList<Hotel> findHotelsResult = new ArrayList<>();
        if (nameOfHotel == null) {
            findHotelsResult = new ArrayList<>(hotelByName.values());
            findHotelsResult.sort(Comparator.comparing(Hotel::getName));
        } else {
            Hotel result = hotelByName.get(nameOfHotel);
            if (result != null) {
                findHotelsResult.add(result);
            }
        }
        return findHotelsResult;
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
