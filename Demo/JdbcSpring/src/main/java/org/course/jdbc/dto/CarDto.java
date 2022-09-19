package org.course.jdbc.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {
    private String vin;
    private String make;
    private String model;
}
