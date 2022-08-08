package org.course;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static org.course.Hotel.findApartment;

public class FindHelper {

    public static String hotelFinderString(String input, ArrayList<Hotel> hotels, Map<String, Hotel> hotelByName) {

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
            try {
                if (firstSpaceIndex == -1) {
                    numberOfGuests = Integer.parseInt(input.trim());
                    nameOfHotel = null;
                } else {
                    numberOfGuests = Integer.parseInt(input.substring(0, firstSpaceIndex));
                    nameOfHotel = input.substring(firstSpaceIndex + 1);
                }
                if (numberOfGuests < 1) {
                    return "Количество гостей не может быть меньше 1, повторите ввод:";
                }
                ArrayList<Hotel> searchResult = findHotel(hotels, nameOfHotel, hotelByName);
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
                if (("".equals(finderHotelString) && nameOfHotel == null ) || !finderHotelString.equals("")) {
                    return "Найдено отелей: " + numberOfHotelsFound + "\n" + finderHotelString + "\nНовый поиск:";
                } else {
                    return "В отеле \"" + nameOfHotel + "\" нет достаточного количества мест\nНовый поиск:";
                }
            } catch (NumberFormatException e) {
                return "Количество гостей это число, повторите ввод:";
            }
        }
    }

    private static ArrayList<Hotel> findHotel(ArrayList<Hotel> hotels, String nameOfHotel, Map<String, Hotel> hotelByName) {
        ArrayList<Hotel> findHotelsResult = new ArrayList<>();
        if (nameOfHotel == null) {
            hotels.sort(Comparator.comparing(Hotel::getName));
            findHotelsResult = hotels;
        } else {
            Hotel result = hotelByName.get(nameOfHotel);
            if (result != null) {
                findHotelsResult.add(result);
            }
        }
        return findHotelsResult;
    }
}
