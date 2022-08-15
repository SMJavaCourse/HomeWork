package org.course.utils;

import org.course.Apartment;
import org.course.Hotel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.course.Hotel.findApartment;
import static org.course.Hotel.printServices;

public class FindHelper {

    private static ArrayList<Hotel> findHotel(String nameOfHotel, Map<String, Hotel> hotelStreamByName) {
        ArrayList<Hotel> findHotelsResult = new ArrayList<>();
        if (nameOfHotel == null) {
            findHotelsResult = new ArrayList<>(hotelStreamByName.values());
            findHotelsResult.sort(Comparator.comparing(Hotel::getName));
        } else {
            Hotel result = hotelStreamByName.get(nameOfHotel);
            if (result != null) {
                findHotelsResult.add(result);
            }
        }
        return findHotelsResult;
    }

    private static Stream<Hotel> findHotelStream(String nameOfHotel, Map<String, Hotel> hotelStreamByName) {

        ArrayList<Hotel> findHotelsResult = new ArrayList<>();
        if (nameOfHotel == null) {
            findHotelsResult = new ArrayList<>(hotelStreamByName.values());
            findHotelsResult.sort(Comparator.comparing(Hotel::getName));
        } else {
            Hotel result = hotelStreamByName.get(nameOfHotel);
            if (result != null) {
                findHotelsResult.add(result);
            }
        }
        return findHotelsResult.stream();
    }

    public static String hotelFinderStringStream(String nameOfHotel, String nameOfCommand, int numberOfGuests, Map<String, Hotel> hotelStreamByName) {

        StringBuilder finderHotelString = new StringBuilder();
        int numberOfHotelsFound = 0;
        ArrayList<Hotel> searchResult = findHotel(nameOfHotel, hotelStreamByName);

        if (searchResult.size() == 0){
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
                            .append(printServices(searchResult.get(0).getApartments()));
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
