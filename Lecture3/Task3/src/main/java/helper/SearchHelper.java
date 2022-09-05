package helper;

import org.course.Apartament;
import org.course.Hotel;
import org.course.SearchInput;
import services.Services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import static org.course.Hotel.searchRoom;
import static org.course.Hotel.searchServices;

public class SearchHelper {
    public static ArrayList<Hotel> findHotel(String nameHotel, Map<String, Hotel> hotelsByName) {
        ArrayList<Hotel> findHotelsResult = new ArrayList<>();
        if (nameHotel == null) { //имя отеля не задано
            findHotelsResult = new ArrayList<>(hotelsByName.values()); //создаем лист и кладем туда value отелей из мапы
            findHotelsResult.sort(Comparator.comparing(Hotel::getName)); //сортируем лист по алфавиту
        } else {
            Hotel result = hotelsByName.get(nameHotel.toLowerCase()); //достаем из мапы имя заданного отеля  присваеваем в result
            if (result == null) { //заданный отель не найден
                return findHotelsResult; //возвращаем имя заданного отеля
            }
            findHotelsResult.add(result); //добавляем наш result в лист
        }
        return findHotelsResult; //возвращаем лист с отелем/отелями
    }


    public static String searchHotelString(String nameHotel, String commandService, int numberOfGuests, Map<String, Hotel> hotelsByName) {
        StringBuilder stringHotelSearch = new StringBuilder(); // стринга билдер
        int numberOfHotelsFound = 0; //кол-во найденных отелей
        ArrayList<Hotel> foundHotel = findHotel(nameHotel, hotelsByName); //лист найденных отелей
        if (foundHotel.size() == 0) { //найденные отели отсутствуют
            stringHotelSearch
                    .append("У нас нет информации по отелю \"")
                    .append(nameHotel)
                    .append("\"");
            return stringHotelSearch.toString(); //возвращаем стрингу с информацией
        }
        if (commandService == null) {
            for (Hotel hotel : foundHotel) {
                ArrayList foundApartmentsList = searchRoom(numberOfGuests, hotel.getApartmentByCapacity());
                int numberFoundApart = foundApartmentsList.size(); //кол-во найденных номеров
                if (numberFoundApart > 0) { //кол-во найденных номеров больше 0
                    stringHotelSearch
                            .append("Отель \"")
                            .append(hotel.getName())
                            .append("\"\nНайдено номеров: ")
                            .append(numberFoundApart)
                            .append("\nНомера:\n")
                            .append(searchRoom(numberOfGuests, hotel.getApartmentByCapacity())
                                    .stream()
                                    .map(Apartament::toString)
                                    .collect(Collectors.joining()));
                    numberOfHotelsFound += 1;
                }
            }
        } else {
            stringHotelSearch
                    .append("Отель: \"")
                    .append(nameHotel)
                    .append("\"\n")
                    .append(searchServices(hotelsByName.get(nameHotel).getApartments()));
            numberOfHotelsFound += 1;
        }
        if (("".equals(stringHotelSearch.toString()) && nameHotel == null) || !stringHotelSearch.toString().equals("")) {
            return "Найдено отелей: " + numberOfHotelsFound + "\n" + stringHotelSearch;
        } else {
            return "В отеле \"" + nameHotel + "\" нет достаточного количества мест";
        }
    }
}

