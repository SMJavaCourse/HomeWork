package org.course.hotels.controller;

import org.course.hotels.dto.ErrorResponse;
import org.course.hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;


@RestController
public class HotelsController {
    private final HotelService hotelService;

    @Autowired
    public HotelsController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("api/hotels/{id}")
    public ResponseEntity getHotelById(@PathVariable String id) {
        var hotel = hotelService.getHotelById(id);
        if (hotel.isPresent()) {
            return ResponseEntity.of(hotel);
        }
        return new ResponseEntity(new ErrorResponse(404, "Отель с id " + id + " не найден"), HttpStatus.NOT_FOUND);
    }

    @PostMapping("api/hotels/query")
    public ResponseEntity getHotels(@Valid @RequestBody queryRequest request) {
        var people = request.people();
        var name = request.name();
        if (people < 1) {
            return new ResponseEntity(new ErrorResponse(400, "поле people обязательное и должно быть больше нуля"), HttpStatus.BAD_REQUEST);
        }
        var hotels = hotelService.hotelFinder(people, name);
        if (hotels.size() != 0) {
            return ResponseEntity.of(Optional.of(hotels));
        }
        if (hotelService.hotelExist(name)) {
            return new ResponseEntity(new ErrorResponse(404, "В отеле '" + name + "' нет свободных мест"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new ErrorResponse(404, "Отель '" + name + "' не найден"), HttpStatus.NOT_FOUND);
    }

    public record queryRequest(
            @NotNull
            int people,
            String name
    ) {
    }
}
