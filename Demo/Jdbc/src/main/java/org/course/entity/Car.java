package org.course.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class Car {
    private String vin;
    private String make;
    private String model;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(vin, car.vin) && Objects.equals(make, car.make) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin, make, model);
    }
}
