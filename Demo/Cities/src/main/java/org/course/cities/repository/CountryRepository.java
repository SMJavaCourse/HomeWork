package org.course.cities.repository;

import org.course.cities.entity.CountryEntity;

import java.util.HashMap;

public class CountryRepository {
    private HashMap<String, CountryEntity> countries = new HashMap<>();

    public CountryRepository() {
        var countryEntity = new CountryEntity();
        countryEntity.setId("RU");
        countryEntity.setName("Россия");
        countries.put(countryEntity.getId(), countryEntity);
    }

    public CountryEntity getById(String id) {
        return countries.get(id);
    }
}
