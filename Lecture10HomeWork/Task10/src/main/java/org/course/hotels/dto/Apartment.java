package org.course.hotels.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {
    private String id;
    private String name;
    private int rooms;
    private int roomNumber;
    private int price;
    private int capacity;
    private ArrayList<String> services;
}