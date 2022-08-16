package org.course.utils;

import lombok.Getter;
import lombok.Setter;
import org.course.services.Services;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Getter
@Setter
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

    private String soutServices() {
        if (services.size() == 0) {
            return "отсутствуют \n";
        } else {
            return services
                    .stream()
                    .map(Services::getName)
                    .collect(Collectors.joining(", ")) + "\n";
        }
    }

    @Override
    public String toString() {
        StringBuilder apartmentToString = new StringBuilder()
                .append("\t\u2219 ")
                .append(getName())
                .append(" (комната номер ")
                .append(numberOfRoom)
                .append("):\n\t\t\u25e6 Цена: ")
                .append(price)
                .append("\n\t\t\u25e6 Дополнительные услуги: ")
                .append(soutServices());
        return apartmentToString.toString();
    }
}
