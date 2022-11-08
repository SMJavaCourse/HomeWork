package org.course;

import org.course.service.HotelService;

import java.time.LocalTime;
import java.util.List;


public class App {
    public static void main(String[] args) throws HotelException {

        var hotelService = new HotelService();

        hotelService.saveHotel(Hotel.builder()
                .name("У мамы лучше")
                .apartments(List.of(new ApartmentOneRoom(1000f, 1, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());

        System.out.println(hotelService.getAllHotels());
        System.out.println(hotelService.removeHotels());


    }

}
