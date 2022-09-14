package org.course.jdbc.repository;

import org.course.jdbc.entity.RepairRequestEntity;

public interface RepairRequestRepository {
    RepairRequestEntity getById(String id);
}
