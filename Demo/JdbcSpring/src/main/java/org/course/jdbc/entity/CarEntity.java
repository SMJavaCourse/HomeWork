package org.course.jdbc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = CarEntity.TABLE)
public class CarEntity {
    public static final String TABLE = "cars";

    @Id
    private String vin;
    private String make;
    private String model;
}
