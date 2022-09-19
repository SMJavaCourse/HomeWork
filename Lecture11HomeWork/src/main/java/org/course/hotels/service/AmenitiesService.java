package org.course.hotels.service;

import org.course.hotels.dto.ServicesEnum;
import org.course.hotels.entity.services.*;
import org.springframework.stereotype.Service;

@Service
public class AmenitiesService {

    public static ServicesAbstract servicesBuilder(String nameOfService, String customProperty, String defaultProperty) {
        switch (ServicesEnum.valueOf(nameOfService.toUpperCase())) {
            case BALCONY -> {
                return new Balcony();
            }
            case CLEANING -> {
                return new Cleaning();
            }
            case CONDITIONER -> {
                return new Conditioner();
            }
            case JACUZZI -> {
                return new Jacuzzi();
            }
            case MEAT -> {
                return new Meat();
            }
            case INTERNET -> {
                if (customProperty == null || "".equals(customProperty)) {
                    return new Internet(Integer.parseInt(defaultProperty));
                } else {
                    return new Internet(Integer.parseInt(customProperty));
                }
            }
        }
        throw new RuntimeException();
    }
}
