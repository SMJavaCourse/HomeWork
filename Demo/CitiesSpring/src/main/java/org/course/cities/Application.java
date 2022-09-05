package org.course.cities;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(Application.class, args);
        var objectMapper = applicationContext.getBean(ObjectMapper.class);
        System.out.println("sdsd");
    }
}
