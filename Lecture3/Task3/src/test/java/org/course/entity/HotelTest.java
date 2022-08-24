package org.course.entity;

import org.course.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.course.entity.Hotel.findApartment;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HotelTest extends TestBase {

    ArrayList<Hotel> hotels = new ArrayList<>();
    Map<String, Hotel> hotelByName;
    int numberOfGuests = 0;

    @BeforeEach
    void setUp() {
        hotels = given.getSomeHotels(10, easyRandom);
        hotelByName = hotels
                .stream()
                .collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity()));
    }

    @Test
    void findAllApartmentsInHotel() {
        Random random = new Random();
        int position = random.nextInt(hotels.size() - 1);
        numberOfGuests = 1;
        ArrayList<Apartment> actual = findApartment(hotels.get(position).getApartments(),numberOfGuests);
        ArrayList<Apartment> expected = hotels.get(position).getApartments();
        assertNotNull(actual);
        assertEquals(expected.size(),actual.size());
        assertEquals(expected,actual);
    }
}