package org.course.jdbc.repository.mapper;

import org.course.jdbc.entity.CarEntity;
import org.course.jdbc.entity.ClientEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<ClientEntity> {
    private static ClientMapper INSTANCE = null;

    private ClientMapper() {
    }

    public static ClientMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClientMapper();
            return INSTANCE;
        }
        return INSTANCE;
    }

    @Override
    public ClientEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClientEntity entity = new ClientEntity();
        entity.setId(rs.getString("id"));
        entity.setFirstName(rs.getString("first_name"));
        entity.setLastName(rs.getString("last_name"));
        return entity;
    }
}
