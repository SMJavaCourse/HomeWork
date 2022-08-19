package org.course.entity;

import org.course.exception.HotelFactoryException;
import org.course.service.HotelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.course.entity.Hotel.findApartment;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    HotelFactory factory = HotelFactory.getInstance();
    ArrayList<Hotel> hotels = new ArrayList<>();
    Map<String, Hotel> hotelByName;
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
    void findAllApartmentsInHotel() {
        numberOfGuests = 1;
        ArrayList<Apartment> actual = findApartment(hotels.get(0).getApartments(),numberOfGuests);
        ArrayList<Apartment> expected = hotels.get(0).getApartments();
        assertEquals(actual,expected);
    }

}