package org.course.cities.service;

import org.course.cities.dto.City;
import org.course.cities.repository.CitiesRepository;
import org.course.cities.repository.CountryRepository;
import org.course.cities.repository.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitiesService {
    private final CitiesRepository citiesRepository;
    private final RegionsRepository regionsRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public CitiesService(CitiesRepository citiesRepository, RegionsRepository regionsRepository, CountryRepository countryRepository) {
        this.citiesRepository = citiesRepository;
        this.regionsRepository = regionsRepository;
        this.countryRepository = countryRepository;
    }

    public City getCity(String id) {
        var cityEntity = citiesRepository.getById(id);
        if (cityEntity == null) {
            return null;
        }
        var regionEntity = regionsRepository.getById(cityEntity.getRegionId());
        var countryEntity = countryRepository.getById(regionEntity.getCountryId());

        var city = new City();
        city.setId(cityEntity.getId());
        city.setName(cityEntity.getName());
        city.setRegionName(regionEntity.getName());
        city.setCountryName(countryEntity.getName());
        return city;
    }
}
