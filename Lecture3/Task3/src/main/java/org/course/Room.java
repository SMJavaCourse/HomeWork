package org.course;

public class Room extends Apartment {
    private Services[] services;


    public Room(int roomsNumber, String cost, int capacity, Services... service) {
        super(roomsNumber, cost, capacity);
        this.services = service;
    }

    public int  getCapacity() {return capacity;}
    public String  getCost() {return cost;}
    @Override
    public String toString() {
        String result = "\n" + roomsNumber + "-комнатный номер (вместимость до " + capacity + " чел.)\nЦена: " + cost + " р/сутки \nУслуги: ";
        for (Services service : services) {
            result += service;
        }
        return result;

    }
}
