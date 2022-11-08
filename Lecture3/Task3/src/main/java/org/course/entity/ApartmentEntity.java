package org.course.entity;

import lombok.Builder;
import lombok.Data;

@Data
public class ApartmentEntity {
    private String id;
    private String apartmentName;
    private String apartmentParamsId;
}
