package org.course.utils;

import org.course.Apartment;
import org.course.Hotel;

import java.util.*;

import static org.course.Hotel.findApartment;
import static org.course.Hotel.printServices;

public class FindHelper {

    private static ArrayList<Hotel> findHotel(Object nameOfHotel, Map<String, Hotel> hotelByName) {
        ArrayList<Hotel> findHotelsResult = new ArrayList<>();
        if (nameOfHotel == null) {
            findHotelsResult = new ArrayList<>(hotelByName.values());
            findHotelsResult.sort(Comparator.comparing(Hotel::getName));
        } else {
            Hotel result = hotelByName.get(nameOfHotel.toString());
            if (result != null) {
                findHotelsResult.add(result);
            }
        }
        return findHotelsResult;
    }

    public static String hotelFinderString(SearchDTO input, Map<String, Hotel> hotelByName) {

        String finderHotelString = "";
        String nameOfHotel = input.getNameOfHotel();
        String nameOfCommand = input.getCommand();
        int numberOfHotelsFound = 0;
        int numberOfGuests = input.getNumberOfGuests();
        ArrayList<Hotel> searchResult = findHotel(nameOfHotel, hotelByName);

        if (searchResult.size() != 0) {
            if ("удобства".equalsIgnoreCase(nameOfCommand)) {
                finderHotelString = "Отель \"" + nameOfHotel + "\"\n" + printServices(searchResult.get(0).getApartments());
            } else {
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
            }
        } else {
            finderHotelString = "У нас нет информации по отелю \"" + nameOfHotel + "\"\nНовый поиск:";
            return finderHotelString;
        }
        if (("".equals(finderHotelString) && nameOfHotel == null) || !finderHotelString.equals("")) {
            finderHotelString = "Найдено отелей: " + numberOfHotelsFound + "\n" + finderHotelString + "\nНовый поиск:";
        } else finderHotelString = "В отеле \"" + nameOfHotel + "\" нет достаточного количества мест\nНовый поиск:";
        return finderHotelString;
    }
}
