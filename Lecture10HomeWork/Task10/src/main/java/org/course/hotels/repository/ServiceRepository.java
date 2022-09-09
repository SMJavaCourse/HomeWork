package org.course.hotels.repository;

import org.course.hotels.dto.ServicesEnum;
import org.course.hotels.entity.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ServiceRepository {

    private final DataSource dataSource;

    @Autowired
    public ServiceRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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
