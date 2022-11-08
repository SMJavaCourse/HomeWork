package org.course.entity;

import lombok.Data;

@Data
public class ApartmentParamsEntity {
    private String id;
    private String roomNumber;
    private Double price;
    private Integer places;
    private String servicesId;
}
