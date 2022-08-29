package org.course.cities.service;

import org.course.cities.dto.Region;
import org.course.cities.repository.CountryRepository;
import org.course.cities.repository.RegionsRepository;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
    private final RegionsRepository regionsRepository = new RegionsRepository();
    private final CountryRepository countryRepository = new CountryRepository();

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
