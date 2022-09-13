package org.course.hotels.controller;

import org.course.hotels.TestBase;
import org.course.hotels.dto.Apartment;
import org.course.hotels.dto.Hotel;
import org.course.hotels.entity.services.ServicesAbstract;
import org.course.hotels.repository.ApartmentRepository;
import org.course.hotels.repository.HotelRepository;
import org.course.hotels.repository.ServiceRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

class HotelsControllerTest extends TestBase {

    ArrayList<String> arrayOfHotelIds = new ArrayList<>();
    ArrayList<String> arrayOfApartmentIds = new ArrayList<>();
    int hotelsQuantity = 10;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    ArrayList<Hotel> hotels;

    @BeforeEach
    void setUp() {
        hotels = given.getSomeHotels(hotelsQuantity, easyRandom);
        for (Hotel hotel : hotels) {
            hotelRepository.save(hotel);
            arrayOfHotelIds.add(hotel.getId());
            for (Apartment apartment : hotel.getApartments()) {
                apartmentRepository.save(apartment, hotel.getId());
                arrayOfApartmentIds.add(apartment.getId());
                for (ServicesAbstract service: apartment.getServices()){
                    serviceRepository.save(apartment.getId(), service.getName(), null);
                }
            }
        }
    }

    @AfterEach
    void cleanUp() {
        serviceRepository.deleteAll();
        apartmentRepository.deleteAll();
        hotelRepository.deleteAll();
//        for (String apartmentId : arrayOfApartmentIds){
//            serviceRepository.deleteByApartmentId(apartmentId);
//            apartmentRepository.deleteById(apartmentId);
//        }
//        for (String hotelId : arrayOfHotelIds) {
//            hotelRepository.deleteById(hotelId);
//        }
    }


    @Test
    void getHotelByExistingId() {
    }

    @Test
    void getHotel() {
    }
}