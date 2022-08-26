package org.course.cities.repository.stub;

import org.course.cities.entity.CityEntity;
import org.course.cities.repository.CitiesRepository;

import java.util.HashMap;

public class CitiesStubRepository implements CitiesRepository {
    private HashMap<String, CityEntity> cities = new HashMap<>();

    public CitiesStubRepository() {
        var cityEntity = new CityEntity();
        cityEntity.setId("1");
        cityEntity.setName("Санкт-Петербург");
        cityEntity.setRegionId("78");
        cities.put(cityEntity.getId(), cityEntity);
    }

    @Override
    public CityEntity getById(String id) {
        return cities.get(id);
    }
}
