package org.course.jdbc.repository.mapper;

import org.course.jdbc.entity.CarEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<CarEntity> {
    private static CarMapper INSTANCE = null;

    private CarMapper() {
    }

    public static CarMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CarMapper();
            return INSTANCE;
        }
        return INSTANCE;
    }

    @Override
    public CarEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        CarEntity entity = new CarEntity();
        entity.setVin(rs.getString("vin"));
        entity.setMake(rs.getString("make"));
        entity.setModel(rs.getString("model"));
        return entity;
    }
}
