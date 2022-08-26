package org.course.cities.service;

import org.course.cities.GlobalStorage;
import org.course.cities.dto.City;
import org.course.cities.repository.CitiesRepository;
import org.course.cities.repository.CountryRepository;
import org.course.cities.repository.RegionsRepository;

public class CitiesService {
    private final GlobalStorage globalStorage;
    private final CitiesRepository citiesRepository;
    private final RegionsRepository regionsRepository;
    private final CountryRepository countryRepository;

    public CitiesService(GlobalStorage globalStorage) {
        this.globalStorage = globalStorage;
        citiesRepository = globalStorage.getCitiesRepository();
        regionsRepository = globalStorage.getRegionsJdbcRepository();
        countryRepository = globalStorage.getCountryJdbcRepository();
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
