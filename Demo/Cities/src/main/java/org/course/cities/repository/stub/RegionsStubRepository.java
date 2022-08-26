package org.course.cities.repository.stub;

import org.course.cities.entity.RegionEntity;
import org.course.cities.repository.RegionsRepository;

import java.util.HashMap;

public class RegionsStubRepository implements RegionsRepository {
    private HashMap<String, RegionEntity> regions = new HashMap<>();

    public RegionsStubRepository() {
        var regionEntity = new RegionEntity();
        regionEntity.setId("78");
        regionEntity.setName("Санкт-Петербург");
        regionEntity.setCountryId("RU");
        regions.put(regionEntity.getId(), regionEntity);
    }
    @Override
    public RegionEntity getById(String id) {
        return regions.get(id);
    }
}
