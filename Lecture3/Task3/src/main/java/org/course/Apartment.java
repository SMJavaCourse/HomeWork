package org.course;

import org.course.services.Services;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
        buildNameOfRoom(rooms);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<Services> getServices() {
        return services;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String soutServices() {
        String textServices = "";
        if (services.size() == 0) {
            textServices = "отсутствуют" + "\n";
        } else {
            textServices = services
                    .stream()
                    .map(Services::getName)
                    .collect(Collectors.joining(", ")) + "\n";
        }
        return textServices;
    }

    @Override
    public String toString() {
        StringBuilder apartmentToString = new StringBuilder()
                .append("\t\u2219 ")
                .append(buildNameOfRoom(rooms))
                .append(" (комната номер ")
                .append(numberOfRoom)
                .append("):\n\t\t\u25e6 Цена: ")
                .append(price)
                .append("\n\t\t\u25e6 Дополнительные услуги: ")
                .append(soutServices());
        return apartmentToString.toString();
    }
}
