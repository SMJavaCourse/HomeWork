package org.course;

import lombok.Builder;
import lombok.Data;
import services.Services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Data
@Builder
public class Apartament {
    private String name;
    private int numberOfApart;
    private int rooms;
    private int capacity;
    private int price;
    private ArrayList<Services> services;

    Apartament(String name, int numberOfApart, int rooms, int capacity, int price, ArrayList<Services> services) {
        this.name = name;
        this.numberOfApart = numberOfApart;
        this.rooms = rooms;
        this.capacity = capacity;
        this.price = price;
        this.services = services;
        printName(rooms);
    }

    public static ApartBuilder builder() {
        return new ApartBuilder();
    }

    private String printName(int rooms) {
        if (rooms == 1) {
            name = "Однокомнатный номер";
        } else if (rooms == 2) {
            name = "Двухкомнатный номер";
        } else if (rooms == 3) {
            name = "Трёхкомнатный номер";
        } else if (rooms == 4) {
            name = "Четырёхкомнатный номер";
        }
        return name;
    }
    private String printServices() {
        if (services.size() == 0) {
            return "удобства отсутствуют";
        } else
            return services
                    .stream()
                    .map(Services::getName)
                    .collect(Collectors.joining(", "));
    }
    @Override
    public String toString() {
        StringBuilder apartmentToString = new StringBuilder()
                .append("\t\u2219 ")
                .append(name)
                .append(" (комната номер ")
                .append(numberOfApart)
                .append("):\n\t\t\u25e6 Цена: ")
                .append(price)
                .append("\n\t\t\u25e6 Вместимость до ")
                .append(capacity)
                .append(" человек")
                .append("\n\t\t\u25e6 Дополнительные услуги: ")
                .append(printServices())
                .append("\n\n");
        return apartmentToString.toString();
    }

    public static class ApartBuilder {
        private String name;
        private int numberOfApart;
        private int rooms;
        private int capacity;
        private int price;
        private ArrayList<Services> services;

        ApartBuilder() {
        }

        public Apartament.ApartBuilder services(Services... services) {
            this.services = new ArrayList<>(Arrays.asList(services));
            return this;
        }
        public ApartBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ApartBuilder numberOfApart(int numberOfApart) {
            this.numberOfApart = numberOfApart;
            return this;
        }

        public ApartBuilder rooms(int rooms) {
            this.rooms = rooms;
            return this;
        }

        public ApartBuilder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public ApartBuilder price(int price) {
            this.price = price;
            return this;
        }

        public ApartBuilder services(ArrayList<Services> services) {
            this.services = services;
            return this;
        }

        public Apartament build() {
            return new Apartament(name, numberOfApart, rooms, capacity, price, services);
        }
    }
}
