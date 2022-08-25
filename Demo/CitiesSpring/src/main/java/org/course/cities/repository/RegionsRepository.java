package org.course.cities.repository;

import org.course.cities.entity.CityEntity;
import org.course.cities.entity.RegionEntity;

import java.util.HashMap;

public class RegionsRepository {
    private HashMap<String, RegionEntity> regions = new HashMap<>();

    public RegionsRepository() {
        var regionEntity = new RegionEntity();
        regionEntity.setId("78");
        regionEntity.setName("Санкт-Петербург");
        regionEntity.setCountryId("RU");
        regions.put(regionEntity.getId(), regionEntity);
    }
    public RegionEntity getById(String id) {
        return regions.get(id);
    }
}
