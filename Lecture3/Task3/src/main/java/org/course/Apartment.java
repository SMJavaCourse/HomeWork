package org.course;

import org.course.services.Services;

public class Apartment {
    //TODO убрать наследников
    private String name;
    private int price;
    private int rooms;
    private int numberOfRoom;
    private int capacity;
    private Services[] services;

    public Apartment(int rooms, int numberOfRoom, int price, int capacity, Services... services) {
        this.rooms = rooms;
        this.numberOfRoom = numberOfRoom;
        this.price = price;
        this.capacity = capacity;
        this.services = services;
    }

    public int getCapacity() {
        return capacity;
    }

    private String getName(int rooms) {
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
        if (services.length == 0) {
            textServices = "отсутствуют" + "\n";
        } else {
            for (int i = 0; i < services.length; i++) {
                textServices += services[i].getName();
                if (i + 1 < services.length) {
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
