package org.course.hotels.controller;

import org.course.hotels.dto.Apartment;
import org.course.hotels.dto.Hotel;
import org.course.hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelsController {
    private final HotelService hotelService;

    @Autowired
    public HotelsController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
        var apartment = Apartment.builder()
                .id("1")
                .name("Номер Стандарт")
                .capacity(2)
                .roomNumber(4)
                .rooms(1)
                .price(1000)
                .services(List.of("Джакуззи", "Шашлычок"))
                .build();

        var hotel = Hotel.builder()
                .id(id)
                .name("Тестовый отель")
                .startTime("14:00")
                .apartments(List.of(apartment))
                .build();

        return ResponseEntity.ok(hotel);
    }

    @GetMapping("api/hotels/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
        var hotel = hotelService.getHotel(id);
        return ResponseEntity.of(hotel);
    }
}
