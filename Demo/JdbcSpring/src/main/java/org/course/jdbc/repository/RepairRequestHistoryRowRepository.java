package org.course.jdbc.repository;

import org.course.jdbc.entity.RepairRequestHistoryRowEntity;

public interface RepairRequestHistoryRowRepository {
    RepairRequestHistoryRowEntity getById(String id);
}
