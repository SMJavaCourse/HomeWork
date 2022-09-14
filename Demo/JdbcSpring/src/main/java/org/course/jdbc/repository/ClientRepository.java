package org.course.jdbc.repository;

import org.course.jdbc.entity.ClientEntity;

public interface ClientRepository {
    ClientEntity getById(String id);
}
