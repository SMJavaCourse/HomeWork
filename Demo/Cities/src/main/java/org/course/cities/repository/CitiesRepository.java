package org.course.cities.repository;

import org.course.cities.entity.CityEntity;

import java.util.HashMap;

public class CitiesRepository {
    private HashMap<String, CityEntity> cities = new HashMap<>();

    public CitiesRepository() {
        var cityEntity = new CityEntity();
        cityEntity.setId("1");
        cityEntity.setName("Санкт-Петербург");
        cityEntity.setRegionId("78");
        cities.put(cityEntity.getId(), cityEntity);
    }

    public CityEntity getById(String id) {
        return cities.get(id);
    }
}
