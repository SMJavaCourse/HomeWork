package org.course.jdbc.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.course.jdbc.entity.RepairRequestHistoryEntity;
import org.course.jdbc.repository.RepairRequestHistoryRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "course.implement", havingValue = "true")
@RequiredArgsConstructor
public class RepairRequestHistoryJDBCRepository implements RepairRequestHistoryRepository {
    @Override
    public RepairRequestHistoryEntity getById(String id) {
        return null;
    }
}
