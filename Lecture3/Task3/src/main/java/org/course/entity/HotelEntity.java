package org.course.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
public class HotelEntity {
    private String id;
    private String name;
    private LocalTime checkinTime;
    private Integer roomsTotalCount;
    private String apartmentsId;
}
