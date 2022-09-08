package org.course.hotels;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.course.hotels.entity.HotelEntity;
import org.course.hotels.repository.HotelRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(Application.class, args);
        var hotelRepository = applicationContext.getBean(HotelRepository.class);
        var hotelEntity = hotelRepository.getById("1");
        System.out.println(hotelEntity);
    }
}
