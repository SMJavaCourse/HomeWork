package org.course.hotels.entity;

import lombok.Data;

import java.util.List;

@Data
public class ApartmentEntity {
    private String id;
    private String hotelId;
    private int rooms;
    private int roomNumber;
    private int price;
    private int capacity;
}