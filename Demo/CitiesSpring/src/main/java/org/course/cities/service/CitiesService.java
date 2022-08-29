package org.course.cities.service;

import org.course.cities.dto.City;
import org.course.cities.repository.CitiesRepository;
import org.course.cities.repository.CountryRepository;
import org.course.cities.repository.RegionsRepository;
import org.springframework.stereotype.Service;

@Service
public class CitiesService {
    private final CitiesRepository citiesRepository = new CitiesRepository();
    private final RegionsRepository regionsRepository = new RegionsRepository();
    private final CountryRepository countryRepository = new CountryRepository();

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
