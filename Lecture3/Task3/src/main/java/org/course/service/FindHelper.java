package org.course.service;

import org.course.entity.Apartment;
import org.course.entity.CommandsEnum;
import org.course.entity.Hotel;

import java.util.*;
import java.util.stream.Collectors;

import static org.course.entity.Hotel.findApartment;
import static org.course.entity.Hotel.printServices;

public class FindHelper {

    private static ArrayList<Hotel> findHotel(String nameOfHotel, Map<String, Hotel> hotelStreamByName) {
        ArrayList<Hotel> findHotelsResult = new ArrayList<>();
        if (nameOfHotel == null) {
            findHotelsResult = new ArrayList<>(hotelStreamByName.values());
            findHotelsResult.sort(Comparator.comparing(Hotel::getName));
        } else {
            Hotel result = hotelStreamByName.get(nameOfHotel.toLowerCase());
            if (result == null) {
                return findHotelsResult;
            }
            findHotelsResult.add(result);
        }
        return findHotelsResult;
    }

    public static String hotelFinderString(String nameOfHotel, String nameOfCommand, int numberOfGuests, Map<String, Hotel> hotelStreamByName) {
        StringBuilder finderHotelString = new StringBuilder();
        int numberOfHotelsFound = 0;
        ArrayList<Hotel> searchResult = findHotel(nameOfHotel, hotelStreamByName);
        if (searchResult.size() == 0) {
            finderHotelString
                    .append("У нас нет информации по отелю \"")
                    .append(nameOfHotel)
                    .append("\"\nНовый поиск:");
            return finderHotelString.toString();
        }
        if (nameOfCommand == null) {
            for (Hotel hotel : searchResult) {
                long numberCount = findApartment(hotel.getApartments(), numberOfGuests).size();
                if (numberCount > 0) {
                    finderHotelString
                            .append("Отель \"")
                            .append(hotel.getName())
                            .append("\":\nПодходящих номеров: ")
                            .append(numberCount)
                            .append("\nНомера:\n")
                            .append(findApartment(hotel.getApartments(), numberOfGuests)
                                    .stream()
                                    .map(Apartment::toString)
                                    .collect(Collectors.joining("")));
                    numberOfHotelsFound += 1;
                }
            }
        } else {
            for (CommandsEnum ignored : CommandsEnum.values()) {
                if (CommandsEnum.AMENITIES.getName().equalsIgnoreCase(nameOfCommand)) {
                    finderHotelString
                            .append("Отель \"")
                            .append(nameOfHotel)
                            .append("\"\n")
                            .append(printServices(hotelStreamByName.get(nameOfHotel).getApartments()));
                    numberOfHotelsFound = searchResult.size();
                    break;
                }
            }
        }
        if (("".equals(finderHotelString.toString()) && nameOfHotel == null) || !finderHotelString.toString().equals("")) {
            return "Найдено отелей: " + numberOfHotelsFound + "\n" + finderHotelString + "\nНовый поиск:";
        } else {
            return "В отеле \"" + nameOfHotel + "\" нет достаточного количества мест\nНовый поиск:";
        }
    }
}
