package org.course.jdbc.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = ClientEntity.TABLE)
public class ClientEntity {
    public static final String TABLE = "clients";

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "clients")
    private List<CarEntity> cars;
}
