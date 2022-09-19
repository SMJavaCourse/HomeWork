package org.course.hotels.service;

import org.course.hotels.dto.Apartment;
import org.course.hotels.dto.Hotel;
import org.course.hotels.entity.HotelEntity;
import org.course.hotels.repository.ApartmentRepository;
import org.course.hotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Optional<Hotel> getHotelById(String id) {
        var hotelEntity = Optional.ofNullable(hotelRepository.findById(id));
        return hotelEntity.map(he -> {
            var hotel = new Hotel();
            hotel.setId(he.getId());
            hotel.setName(he.getName());
            hotel.setStartTime(he.getStartTime());
            var apartments = apartmentRepository.allApartmentsInHotel(hotel.getId());
            hotel.setApartments(apartments);
            return hotel;
        });
    }
    public ArrayList<Hotel> hotelFinder(int numberOfGuests, String nameOfHotel) {
        ArrayList<HotelEntity> entityArrayList = new ArrayList<>();
        ArrayList<Hotel> result = new ArrayList<>();
        if (nameOfHotel == null || "".equals(nameOfHotel)) {
            entityArrayList = hotelRepository.getAllHotels();
        } else {
            entityArrayList.add(hotelRepository.findHotelByName(nameOfHotel));
        }
        if (entityArrayList.size() != 0) {
            for (HotelEntity hotelEntity : entityArrayList) {
                ArrayList<Apartment> apartmentsInHotel = apartmentRepository.suitableApartments(hotelEntity.getId(), numberOfGuests);
                long numberCount = apartmentsInHotel.size();
                if (numberCount > 0) {
                    var hotel = new Hotel();
                    hotel.setId(hotelEntity.getId());
                    hotel.setName(hotelEntity.getName());
                    hotel.setStartTime(hotelEntity.getStartTime());
                    hotel.setApartments(apartmentsInHotel);
                    result.add(hotel);
                }
            }
        }
        return result;
    }
    public Boolean hotelExist(String nameOfHotel){
        return hotelRepository.findHotelByName(nameOfHotel).getId() != null;
    }
}