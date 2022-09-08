package org.course.hotels.service;

import org.course.hotels.dto.Apartment;
import org.course.hotels.dto.Hotel;
import org.course.hotels.repository.ApartmentRepository;
import org.course.hotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final ApartmentRepository apartmentRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository, ApartmentRepository apartmentRepository) {
        this.hotelRepository = hotelRepository;
        this.apartmentRepository = apartmentRepository;
    }

    public Optional<Hotel> getHotel(String id) {
        var hotelEntity = Optional.ofNullable(hotelRepository.findById(id));
        return hotelEntity.map(he -> {
            var hotel = new Hotel();
            hotel.setId(he.getId());
            hotel.setName(he.getName());
            hotel.setStartTime(he.getStartTime());
            hotel.setApartments(he.getApartments());
            return hotel;
        });
    }

    public Optional<Hotel> hotelQuery(int people, String name) {
        var hotelEntity = Optional.ofNullable(hotelRepository.findHotelByName(name, people));
        return hotelEntity.map(he -> {
            var hotel = new Hotel();
            hotel.setId(he.getId());
            hotel.setName(he.getName());
            hotel.setStartTime(he.getStartTime());
            hotel.setApartments(he.getApartments());
            return hotel;
        });
    }
}