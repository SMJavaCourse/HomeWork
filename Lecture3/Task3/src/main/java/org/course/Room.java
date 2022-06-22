package org.course;

public class Room extends Apartment {
    private String service;

    public Room(int roomsNumber, String cost, int capacity, String service) {
        super(roomsNumber, cost, capacity);
        this.service = service;
    }


    @Override
    public String toString() {
        return "\n" + roomsNumber + "-комнатный номер (вместимость до " + capacity + " чел.)\nЦена: " + cost + " р/сутки \nУслуги: " + service;
    }
}
