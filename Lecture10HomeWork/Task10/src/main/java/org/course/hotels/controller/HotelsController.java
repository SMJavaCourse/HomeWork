package org.course.hotels.controller;

import org.course.hotels.dto.ErrorResponse;
import org.course.hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@RestController
public class HotelsController {
    private final HotelService hotelService;

    @Autowired
    public HotelsController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("api/hotels/{id}")
    public ResponseEntity findHotel(@PathVariable String id) {
        var hotel = hotelService.getHotel(id);
        if (hotel.isPresent()) {
            return ResponseEntity.of(hotel);
        }
        return new ResponseEntity(new ErrorResponse(404, "Отель с id " + id + " не найден"), HttpStatus.NOT_FOUND);
    }

    @PostMapping("api/hotels/query")
    public ResponseEntity findApartments(@Valid @RequestBody queryRequest request) {
        var people = request.people();
        var name = request.name();
        var hotel = hotelService.hotelQuery(Integer.parseInt(people), name);
        if (hotel.isPresent()) {
            return ResponseEntity.of(hotel);
        }
        return new ResponseEntity(new ErrorResponse(404, "Отель \"" + name + "\" не найден"), HttpStatus.NOT_FOUND);
    }

    public record queryRequest(
            @NotNull
            String people,
            String name
    ) {}

}