package org.course.cities.repository.stub;

import org.course.cities.entity.CountryEntity;
import org.course.cities.repository.CountryRepository;

import java.util.HashMap;

public class CountryStubRepository implements CountryRepository {
    private HashMap<String, CountryEntity> countries = new HashMap<>();

    public CountryStubRepository() {
        var countryEntity = new CountryEntity();
        countryEntity.setId("RU");
        countryEntity.setName("Россия");
        countries.put(countryEntity.getId(), countryEntity);
    }

    @Override
    public CountryEntity getById(String id) {
        return countries.get(id);
    }
}
