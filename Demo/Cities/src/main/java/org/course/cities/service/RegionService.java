package org.course.cities.service;

import org.course.cities.dto.Region;
import org.course.cities.repository.RegionsRepository;
import org.course.cities.repository.stub.CountryStubRepository;
import org.course.cities.repository.stub.RegionsStubRepository;

public class RegionService {
    private final RegionsRepository regionsRepository = new RegionsStubRepository();
    private final CountryStubRepository countryRepository = new CountryStubRepository();

    public Region getCity(String id) {
        var regionEntity = regionsRepository.getById(id);
        if (regionEntity == null) {
            return null;
        }
        var countryEntity = countryRepository.getById(regionEntity.getCountryId());

        var region = new Region();
        region.setId(regionEntity.getId());
        region.setName(regionEntity.getName());
        region.setCountryName(countryEntity.getName());
        return region;
    }
}
