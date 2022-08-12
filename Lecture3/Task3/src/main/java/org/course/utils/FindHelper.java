package org.course.utils;

import org.course.Apartment;
import org.course.Hotel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

import static org.course.Hotel.findApartment;
import static org.course.Hotel.printServices;

public class FindHelper {

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

    public static String hotelFinderString(String nameOfHotel, String nameOfCommand, int numberOfGuests, Map<String, Hotel> hotelByName) {

        String finderHotelString = "";
        int numberOfHotelsFound = 0;
        ArrayList<Hotel> searchResult = findHotel(nameOfHotel, hotelByName);

        if (searchResult.size() == 0) {
            finderHotelString = "У нас нет информации по отелю \"" + nameOfHotel + "\"\nНовый поиск:";
            return finderHotelString;
        }
        if (nameOfCommand == null) {
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
            for (CommandsEnum eachEnum : CommandsEnum.values()) {
                if (CommandsEnum.AMENITIES.getName().equalsIgnoreCase(nameOfCommand)) {
                    finderHotelString = "Отель \"" + nameOfHotel + "\"\n" + printServices(searchResult.get(0).getApartments());
                    numberOfHotelsFound = searchResult.size();
                    break;
                }
            }
        }
        if (("".equals(finderHotelString) && nameOfHotel == null) || !finderHotelString.equals("")) {
            finderHotelString = "Найдено отелей: " + numberOfHotelsFound + "\n" + finderHotelString + "\nНовый поиск:";
        } else {
            finderHotelString = "В отеле \"" + nameOfHotel + "\" нет достаточного количества мест\nНовый поиск:";
        }
        return finderHotelString;
    }
}
