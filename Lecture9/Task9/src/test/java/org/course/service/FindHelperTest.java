package org.course.service;

import org.course.TestBase;
import org.course.entity.CommandsEnum;
import org.course.entity.Hotel;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FindHelperTest extends TestBase {

    ArrayList<Hotel> hotels = new ArrayList<>();
    Map<String, Hotel> hotelByName;
    String nameOfCommand = null;
    String nameOfHotel = null;
    int numberOfGuests = 0;
    Random random = new Random();

    @BeforeAll
    void setUp() {
        hotels = given.getSomeHotels(10, easyRandom);
        hotelByName = hotels
                .stream()
                .collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity()));
    }

    @BeforeEach
    void init() {
        nameOfCommand = null;
        nameOfHotel = null;
        numberOfGuests = 1;
    }

    @Test
    void hotelIsNotExists() {
        String nameOfHotel = new EasyRandom().nextObject(String.class);
//        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName);
//        String expected = "У нас нет информации по отелю \"" + nameOfHotel + "\"\nНовый поиск:";
//        assertEquals(expected, actual);
    }

    @Test
    void hotelHasEnoughPlaces() {
        numberOfGuests = random.nextInt(5) + 1;
        nameOfHotel = hotels.get(random.nextInt(hotels.size())).getName();
//        ArrayList<Hotel> actual = findHotel(nameOfHotel, hotelByName);
//        ArrayList<Hotel> expected = new ArrayList<>();
//        expected.add(hotelByName.get(nameOfHotel.toLowerCase()));
//        assertEquals(expected, actual);
    }

    @Test
    void hotelDoesntHaveEnoughPlaces() {
        numberOfGuests = 1000;
        nameOfHotel = hotels.get(random.nextInt(hotels.size())).getName();
//        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName);
//        String expected = "В отеле \"" + nameOfHotel + "\" нет достаточного количества мест\nНовый поиск:";
//        assertEquals(expected, actual);
    }

    @Test
    void notEnoughPlacesInAnyHotel() {
        numberOfGuests = 1000;
//        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName);
//        assertEquals("Найдено отелей: 0\n\nНовый поиск:", actual);
    }


    @Test
    void searchCaseNonsensitive() {
        nameOfHotel = hotels.get(random.nextInt(hotels.size())).getName();
//        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName).replaceAll("\n.*", "");
//        assertEquals("Найдено отелей: 1", actual);
    }

    @Test
    void findAllHotels() {
//        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName).replaceAll("\n.*", "");
//        String expected = "Найдено отелей: " + hotels.size();
//        assertEquals(expected, actual);
    }

    @Test
    void checkAmenities() {
        nameOfHotel = hotels.get(random.nextInt(hotels.size())).getName();
        nameOfCommand = CommandsEnum.AMENITIES.getName();
//        String actual = hotelFinderString(nameOfHotel, nameOfCommand, numberOfGuests, hotelByName).replaceAll("\n.*", "");
//        assertEquals("Найдено отелей: 1", actual);
    }
}