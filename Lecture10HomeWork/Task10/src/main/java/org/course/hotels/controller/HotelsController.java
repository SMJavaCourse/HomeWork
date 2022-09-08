package org.course.hotels.controller;

import org.course.hotels.dto.ErrorResponse;
import org.course.hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HotelsController {
    private final HotelService hotelService;

    @Autowired
    public HotelsController(HotelService hotelService) {
        this.hotelService = hotelService;
    }   

    @GetMapping("api/hotels/{id}")
    public ResponseEntity getHotelById(@PathVariable String id) {
        var hotel = hotelService.getHotel(id);
        if (hotel.isPresent()) {
            return ResponseEntity.of(hotel);
        }
        return new ResponseEntity(new ErrorResponse("404","Отель не найден"), HttpStatus.NOT_FOUND);
    }
}