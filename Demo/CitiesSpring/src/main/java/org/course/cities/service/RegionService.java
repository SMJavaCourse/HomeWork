package org.course.cities.service;

import org.course.cities.dto.Region;
import org.course.cities.repository.CountryRepository;
import org.course.cities.repository.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
    private RegionsRepository regionsRepository;
    private CountryRepository countryRepository;

    @Autowired
    public RegionService(RegionsRepository regionsRepository, CountryRepository countryRepository) {
        this.regionsRepository = regionsRepository;
        this.countryRepository = countryRepository;
    }

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
