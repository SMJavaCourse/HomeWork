package org.course.jdbc.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.course.jdbc.entity.ClientEntity;
import org.course.jdbc.repository.ClientRepository;
import org.course.jdbc.repository.mapper.ClientMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "course.implement", havingValue = "true")
@RequiredArgsConstructor
public class ClientJDBCRepository implements ClientRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public ClientEntity getById(String id) {
        return jdbcTemplate.queryForObject("select id, first_name, last_name from clients where id=?", ClientMapper.getInstance(), id);
    }
}
