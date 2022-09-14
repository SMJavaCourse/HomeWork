package org.course.jdbc.repository.mapper;

import org.course.jdbc.entity.RepairRequestEntity;
import org.course.jdbc.entity.RepairRequestStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairRequestMapper implements RowMapper<RepairRequestEntity> {
    private static RepairRequestMapper INSTANCE = null;

    private RepairRequestMapper() {
    }

    public static RepairRequestMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RepairRequestMapper();
            return INSTANCE;
        }
        return INSTANCE;
    }

    @Override
    public RepairRequestEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        RepairRequestEntity entity = new RepairRequestEntity();
        entity.setId(rs.getString("id"));
        entity.setStatus(RepairRequestStatus.valueOf(rs.getString("status")));
        entity.setClientId(rs.getString("client_id"));
        entity.setCarVin(rs.getString("car_vin"));
        entity.setCreatedTs(rs.getTimestamp("created_ts").toLocalDateTime());
        return entity;
    }
}
