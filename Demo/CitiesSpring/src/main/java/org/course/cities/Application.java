package org.course.cities;


import org.course.cities.repository.CitiesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        var context = SpringApplication.run(Application.class, args);
        var citiesRepository = context.getBean(CitiesRepository.class);
        var byId = citiesRepository.getById("1");
        System.out.println("Done");
    }
}
