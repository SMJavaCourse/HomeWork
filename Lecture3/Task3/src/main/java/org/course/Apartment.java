package org.course;

import org.course.services.Services;

import java.util.ArrayList;

public class Apartment {
    private String name;
    private int price;
    private int rooms;
    private int numberOfRoom;
    private int capacity;
    private ArrayList<Services> services;

    public Apartment(int rooms, int numberOfRoom, int price, int capacity, ArrayList<Services> services) {
        this.rooms = rooms;
        this.numberOfRoom = numberOfRoom;
        this.price = price;
        this.capacity = capacity;
        this.services = services;
    }

    public int getCapacity() {
        return capacity;
    }
    public int getRooms() {
        return rooms;
    }
    public int getNumberOfRoom() {
        return numberOfRoom;
    }
    public ArrayList<Services> getServices() {
        return services;
    }

    public String getName(int rooms) {
        if (rooms == 1) {
            name = "Однокомнатный номер";
        } else if (rooms == 2) {
            name = "Двухкомнатный номер";
        } else if (rooms == 3) {
            name = "Трёхкомнатный номер";
        }
        return name;
    }

    private String soutServices() {
        String textServices = "";
        if (services.size() == 0) {
            textServices = "отсутствуют" + "\n";
        } else {
            for (int i = 0; i < services.size(); i++) {
                textServices += services.get(i).getName();
                if (i + 1 < services.size()) {
                    textServices += ", ";
                } else {
                    textServices += "\n";
                }
            }
        }
        return textServices;
    }

    @Override
    public String toString() {
        String text = "\t\u2219 " + getName(rooms) +
                " (комната номер " + numberOfRoom + "):\n\t\t\u25e6 Цена: " + price +
                "\n\t\t\u25e6 Дополнительные услуги: " + soutServices();
        return text;
    }
}
