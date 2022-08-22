package org.course.service;


import org.course.entity.Hotel;
import org.course.exception.HotelFactoryException;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.course.service.FindHelper.hotelFinderString;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FindHelperTest {

    HotelFactory factory = HotelFactory.getInstance();
    ArrayList<Hotel> hotels = new ArrayList<>();
    Map<String, Hotel> hotelByName;
    String nameOfCommand = null;
    String nameOfHotel = null;
    int numberOfGuests = 0;

    @BeforeAll
    void setUp() throws HotelFactoryException {
        hotels.add(factory.createHotel("У мамы лучше"));
        hotels.add(factory.createHotel("Шашлычок"));
        hotelByName = hotels
                .stream()
                .collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity()));
    }

    @Test
    void hotelDoesntExists() {
        String nameOfHotel = new EasyRandom().nextObject(String.class);
        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName);
        String expected = "У нас нет информации по отелю \"" + nameOfHotel + "\"\nНовый поиск:";
        assertEquals(expected,actual);
    }

    @Test
    void hotelHasEnoughPlaces() {
        numberOfGuests = 7;
        nameOfHotel = "Шашлычок";
        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName).replaceAll("\n.*", "");
        assertEquals("Найдено отелей: 1",actual);
    }

    @Test
    void hotelDoesntHaveEnoughPlaces() {
        numberOfGuests = 1000;
        nameOfHotel = "Шашлычок";
        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName);
        String expected = "В отеле \"" + nameOfHotel + "\" нет достаточного количества мест\nНовый поиск:";
        assertEquals(expected,actual);
    }

    @Test
    void notEnoughPlaces() {
        numberOfGuests = 1000;
        String actual = hotelFinderString(null, nameOfCommand, numberOfGuests, hotelByName);
        assertEquals("Найдено отелей: 0\n\nНовый поиск:",actual);
    }


    @Test
    void searchCaseNonsensitive() {
        numberOfGuests = 1;
        nameOfHotel = "ШашЛЫчоК";
        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName).replaceAll("\n.*", "");
        assertEquals("Найдено отелей: 1",actual);
    }

    @Test
    void findAllHotels() {
        numberOfGuests = 1;
        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName).replaceAll("\n.*", "");
        String expected = "Найдено отелей: " + hotels.size();
        assertEquals(expected,actual);
    }

    @Test
    void checkAmenities() {
        nameOfHotel = "шашлычок";
        nameOfCommand = "удобства";
        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName).replaceAll("\n.*", "");
        assertEquals("Найдено отелей: 1",actual);
    }

}