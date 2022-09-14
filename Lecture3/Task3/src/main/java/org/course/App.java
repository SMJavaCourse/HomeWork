package org.course;

import org.course.service.HotelService;
import org.course.utils.DbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Properties;


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
