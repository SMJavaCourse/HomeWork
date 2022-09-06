package org.course.cities.repository;

import org.course.cities.entity.RegionEntity;

public interface RegionsRepository {
    RegionEntity getById(String id);
}
