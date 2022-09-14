package org.course.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class HotelModel {
    private String hotelName;
    private Integer apartmentsId;
    private LocalTime checkInTime;
    private Integer rooms;

}
