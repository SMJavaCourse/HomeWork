package org.course.hotels.service;

import org.course.hotels.dto.Hotel;
import org.course.hotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Optional<Hotel> getHotel(String id) {
        var hotelEntity = Optional.ofNullable(hotelRepository.getById(id));
        return hotelEntity.map(he -> {
            var hotel = new Hotel();
            hotel.setId(he.getId());
            hotel.setName(he.getName());
            hotel.setStartTime(he.getStartTime());
            return hotel;
        });
    }
}
