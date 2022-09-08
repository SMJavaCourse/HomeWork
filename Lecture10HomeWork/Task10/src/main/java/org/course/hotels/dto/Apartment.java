package org.course.hotels.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {
    private String id;
    private String hotelId;
    private int rooms;
    private int numberOfRoom;
    private int price;
    private int capacity;
    private String name;
    private List<String> services;

    public Apartment(String id, String hotelId, int rooms, int numberOfRoom, int price, int capacity) {
        this.id = id;
        this.hotelId = hotelId;
        this.rooms = rooms;
        this.numberOfRoom = numberOfRoom;
        this.price = price;
        this.capacity = capacity;
        buildNameOfRoom(rooms);
    }
    private String buildNameOfRoom(int rooms) {
        if (rooms == 1) {
            name = "Однокомнатный номер";
        } else if (rooms == 2) {
            name = "Двухкомнатный номер";
        } else if (rooms == 3) {
            name = "Трёхкомнатный номер";
        }
        return name;
    }
}
