package org.course.jdbc.repository;

import org.course.jdbc.entity.RepairRequestHistoryEntity;

public interface RepairRequestHistoryRepository {
    RepairRequestHistoryEntity getById(String id);
}
