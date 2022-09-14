package org.course.jdbc.repository.jdbc;

import org.course.jdbc.entity.ClientEntity;
import org.course.jdbc.repository.ClientRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "course.implement", havingValue = "true")
public class ClientJDBCRepository implements ClientRepository {
    @Override
    public ClientEntity getById(String id) {
        return null;
    }
}
