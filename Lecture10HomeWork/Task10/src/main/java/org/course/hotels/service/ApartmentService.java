package org.course.hotels.service;

import org.course.hotels.dto.Apartment;
import org.course.hotels.dto.Hotel;
import org.course.hotels.repository.ApartmentRepository;
import org.course.hotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    @Autowired
    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public Optional<Apartment> getApartment(String id) {
        var apartmentEntity = Optional.ofNullable(apartmentRepository.findApartmentById(id));
        return apartmentEntity.map(he -> {
            var apartment = new Apartment();
            apartment.setId(he.getId());
            apartment.setName(he.getName());
            apartment.setRooms(he.getRooms());
            apartment.setRoomNumber(he.getRoomNumber());
            apartment.setPrice(he.getPrice());
            apartment.setCapacity(he.getCapacity());
            apartment.setServices(he.getServices());
            return apartment;
        });
    }
}