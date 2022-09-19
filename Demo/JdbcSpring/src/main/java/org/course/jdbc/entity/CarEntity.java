package org.course.jdbc.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = CarEntity.TABLE)
public class CarEntity {
    public static final String TABLE = "cars";

    @Id
    private String vin;
    private String make;
    private String model;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "car_client",
            joinColumns = @JoinColumn(name = "car_vin"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<ClientEntity> clients;
}
