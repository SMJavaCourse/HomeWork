package org.course.jdbc.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.course.jdbc.entity.RepairRequestEntity;
import org.course.jdbc.repository.RepairRequestRepository;
import org.course.jdbc.repository.mapper.RepairRequestMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "course.implement", havingValue = "true")
@RequiredArgsConstructor
public class RepairRequestJDBCRepository implements RepairRequestRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public RepairRequestEntity getById(String id) {
        return jdbcTemplate.queryForObject("select id, status, client_id, car_vin, created_ts from repair_request where id=?", RepairRequestMapper.getInstance(), id);
    }
}
