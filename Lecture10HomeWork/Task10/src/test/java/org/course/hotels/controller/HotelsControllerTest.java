package org.course.hotels.controller;

import io.restassured.RestAssured;
import org.course.hotels.TestBase;
import org.course.hotels.dto.Apartment;
import org.course.hotels.dto.Hotel;
import org.course.hotels.entity.services.ServicesAbstract;
import org.course.hotels.repository.ApartmentRepository;
import org.course.hotels.repository.HotelRepository;
import org.course.hotels.repository.ServiceRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


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
    }

    @Test
    @DisplayName("Получение отеля по id")
    void getHotelByIdSuccess() {
        var hotel = hotels.get(0);
        var requestString = "http://localhost:8080/api/hotels/" + hotel.getId();
        RestAssured
                .when().get(requestString).then()
                .assertThat()
                .statusCode(200)
                .and().body("size()",is(notNullValue()))
                .and().body("name",is(hotel.getName()))
                .and().body("apartments.size()", is(hotel.getApartments().size()));
    }
    @Test
    @DisplayName("Получение апартаментов в составе отеля по его id")
    void getHotelApartmentsByIdSuccess() {
        var hotel = hotels.get(0);
        var apartment = hotel.getApartments().get(0);
        var requestString = "http://localhost:8080/api/hotels/" + hotel.getId();
        RestAssured
                .when().get(requestString).then()
                .assertThat()
                .and().body("apartments.size()", is(hotel.getApartments().size()))
                .and().body("apartments[0].id",is(apartment.getId()))
                .and().body("apartments[0].name",is(notNullValue()))
                .and().body("apartments[0].rooms",is(apartment.getRooms()))
                .and().body("apartments[0].roomNumber",is(apartment.getRoomNumber()))
                .and().body("apartments[0].price",is(apartment.getPrice()))
                .and().body("apartments[0].capacity",is(apartment.getCapacity()))
                .and().body("apartments[0].services.size()",is(apartment.getServices().size()))
                .and().body("apartments[0].services[0].name",is(apartment.getServices().get(0).getName()));
    }

    @Test
    @DisplayName("Ошибка получения несуществующего отеля по id")
    void getHotelByIdNotFound() {
        var notExistRandomId = UUID.randomUUID().toString() + LocalDate.now();
        var requestString = "http://localhost:8080/api/hotels/" + notExistRandomId;
        var expectedMessage = "Отель с id " + notExistRandomId + " не найден";
        RestAssured
                .when().get(requestString).then()
                .assertThat()
                .statusCode(404)
                .and().body("size()",is(notNullValue()))
                .and().body("message",is(expectedMessage));
    }


    @Test
    void testGetHotel() {
    }
}