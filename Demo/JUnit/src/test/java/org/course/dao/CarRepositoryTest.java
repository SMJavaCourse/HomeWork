package org.course.dao;

import org.course.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRepositoryTest extends TestBase {

    private final CarRepository carRepository = CarRepository.getInstance();

    @BeforeEach
    void setUp() {
        RepositoryUtils.deleteAllCars();
    }

    @Test
    public void getAll_shouldReturnAll() {
        given.cars().withSome(3).build();
        var cars = carRepository.all();
        assertEquals(3, cars.size());
    }

    @Test
    public void getAll_shouldReturnEmptyAll() {
        var cars = carRepository.all();
        assertEquals(0, cars.size());
    }

}
