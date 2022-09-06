package org.course.cities.repository;

import org.course.cities.entity.CityEntity;

public interface CitiesRepository {
    CityEntity getById(String id);
}
