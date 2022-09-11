package org.course;

import org.course.Factory.HotelFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Apartment {

    private final int numberOfApart;
    private final int rooms;
    private final float price;
    private final String checkInTime;
    private final int capacity;
    private final List<Amenity> amenities;

    public int getCapacity() {
        return capacity;
    }

    public Apartment(int numberOfApart, int rooms, float price, String checkInTime, int capacity, List<Amenity> amenities) {
        this.numberOfApart = numberOfApart;
        this.rooms = rooms;
        this.price = price;
        this.checkInTime = checkInTime;
        this.capacity = capacity;
        this.amenities = amenities;
    }

    public void print() {
        String a = switch (rooms) {
            case 1 -> " -Однокомнатный номер";
            case 2 -> " -Двухкомнатный номер";
            case 3 -> " -Трехкомнатный номер";
            case 4 -> " -Четырехкомнатный номер";
            default -> "";
        };

        System.out.print(a);
        System.out.println(" (комната номер: " + numberOfApart + ")");
        System.out.println("    Цена: " + price + " р/сутки");
        System.out.println("    Вместимость до " + capacity + " человек");
        System.out.println("    Время заселения: " + checkInTime);
        System.out.println("    Дополнительные услуги: " + amenitiesToString(amenities));
    }

    private String amenitiesToString(List<Amenity> amenities) {
        return amenities.stream().map(Amenity::getName)
                .collect(Collectors.joining(", "));
    }
}