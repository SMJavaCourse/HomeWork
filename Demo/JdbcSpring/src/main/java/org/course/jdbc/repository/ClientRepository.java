package org.course.jdbc.repository;

import org.course.jdbc.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, String> {
    ClientEntity getById(String id);
}
