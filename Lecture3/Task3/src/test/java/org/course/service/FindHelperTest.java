package org.course.service;

import org.course.dto.SearchInput;
import org.course.entity.CommandsEnum;
import org.course.entity.Hotel;
import org.course.exception.HotelFactoryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.course.service.FindHelper.hotelFinderString;
import static org.course.service.ValidationInput.validator;
import static org.junit.jupiter.api.Assertions.*;

class FindHelperTest {

    HotelFactory factory = HotelFactory.getInstance();
    ArrayList<Hotel> hotels = new ArrayList<>();
    Map<String, Hotel> hotelByName;
    String nameOfCommand = null;
    String nameOfHotel = null;
    int numberOfGuests = 0;

    @BeforeEach
    void setUp() throws HotelFactoryException {
        hotels.add(factory.createHotel("У мамы лучше"));
        hotels.add(factory.createHotel("Шашлычок"));
        hotelByName = hotels
                .stream()
                .collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity()));
    }

    @Test
    void hotelDoesntExists() throws HotelFactoryException {
        nameOfHotel = "hotelThatDoesn'tExists";
        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName);
        String expected = "У нас нет информации по отелю \"hotelThatDoesn'tExists\"\nНовый поиск:";
        assertEquals(actual,expected);
    }

    @Test
    void hotelDoesntHaveEnoughtPlaces() {
        numberOfGuests = 1000;
        nameOfHotel = "Шашлычок";
        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName);
        String expected = "В отеле \"" + nameOfHotel + "\" нет достаточного количества мест\nНовый поиск:";
        assertEquals(actual,expected);
    }

    @Test
    void searchDontCaseSensitive() {
        numberOfGuests = 1;
        nameOfHotel = "ШашЛЫчоК";
        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName).replaceAll("\n.*", "");
        String expected = "Найдено отелей: 1";
        assertEquals(actual,expected);
    }

    @Test
    void findAllHotels() {
        numberOfGuests = 1;
        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName).replaceAll("\n.*", "");
        String expected = "Найдено отелей: " + hotels.size();
        assertEquals(actual,expected);
    }

    @Test
    void checkAmenities() {
        nameOfHotel = "шашлычок";
        nameOfCommand = "удобства";
        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName);
        String expected = "Найдено отелей: 1\n" +
                "Отель \"шашлычок\"\n" +
                "Количество доступных удобств: 4\n" +
                "Удобство \"джакузи\" доступно в номерах:\n" +
                "\n" +
                "\t∙Трёхкомнатный номер LUXURY (комната номер 33)\n" +
                "Удобство \"балкон\" доступно в номерах:\n" +
                "\n" +
                "\t∙Двухкомнатный номер (комната номер 22)\n" +
                "Удобство \"уборка номера\" доступно в номерах:\n" +
                "\n" +
                "\t∙Двухкомнатный номер (комната номер 22)\n" +
                "\t∙Трёхкомнатный номер LUXURY (комната номер 33)\n" +
                "Удобство \"шашлык\" доступно в номерах:\n" +
                "\n" +
                "\t∙Однокомнатный номер (комната номер 11)\n" +
                "\n" +
                "Новый поиск:";
        assertEquals(actual,expected);
    }
}