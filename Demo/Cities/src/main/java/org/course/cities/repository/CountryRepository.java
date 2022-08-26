package org.course.cities.repository;

import org.course.cities.entity.CountryEntity;

public interface CountryRepository {
    CountryEntity getById(String id);
}
