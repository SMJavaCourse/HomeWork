package org.course.dao;

import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.course.entity.Car;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository extends Repository<Car, String> {
    private static final Map<String, Car> carByVin = new HashMap<>();
    private static volatile CarRepository instance;

    public static CarRepository getInstance() {
        var localInstance = instance;
        if (localInstance == null) {
            synchronized (CarRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new CarRepository();
                }
            }
        }
        return localInstance;
    }

    private CarRepository() {
    }

    @Override
    public List<Car> all() {
        return carByVin.values().stream().sorted(defaultComparator()).toList();
    }

    @SneakyThrows
    public Car save(Car car) {
        if (StringUtils.isBlank(car.getVin())) {
            throw new Exception("Vin cannot be blank");
        }
        carByVin.put(car.getVin(), car);
        return car;
    }

    public Car byId(String id) {
        return carByVin.get(id);
    }

    @Override
    void deleteAll() {
        carByVin.clear();
    }

    public List<Car> find(List<String> vins) {
        var stream = carByVin.values().stream();
        if (CollectionUtils.isNotEmpty(vins)) {
            stream = stream.filter(rr -> vins.contains(rr.getVin()));
        }
        return stream.sorted(defaultComparator()).toList();
    }

    private Comparator<Car> defaultComparator() {
        return Comparator.comparing(Car::getVin);
    }

}
