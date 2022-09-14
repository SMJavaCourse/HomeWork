package org.course.jdbc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = ClientEntity.TABLE)
public class ClientEntity {
    public static final String TABLE = "clients";

    @Id
    private String id;
    private String firstName;
    private String lastName;
}
