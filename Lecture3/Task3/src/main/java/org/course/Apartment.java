package org.course;

import org.course.additions.Addition;

import java.time.LocalTime;

public abstract class Apartment {
    private String additionsHeader = "";
    private String[] additionsList = {""};
    private String roomsNumber;
    private int numberOfRooms;
    private int price;
    private int capacity;
    private LocalTime checkInTime;
    private int apartmentNumber;
    private Addition[] additions;

    public Apartment(int numberOfRooms, int price, int capacity, int apartmentNumber, Addition[] additions, LocalTime checkInTime) {
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.capacity = capacity;
        this.apartmentNumber = apartmentNumber;
        this.additions = additions;
        this.checkInTime = checkInTime;
    }

    public int getCapacity() {
        return capacity;
    }

    //    Вывод:
    public String apartmentInfo() {
        switch (numberOfRooms) {
            case 1 -> roomsNumber = "\n— Однокомнатный номер";
            case 2 -> roomsNumber = "\n— Двухкомнатный номер";
            case 3 -> roomsNumber = "\n— Трехкомнатный номер";
        }
        if (additions != null) {
            additionsList = new String[additions.length];
            additionsHeader = "\n\t— Дополнительные услуги: ";
            for (int i = 0; i < additions.length; i++) {
                    additionsList[i] = additions[i].getName();
            }
        }
        return roomsNumber + " (комната номер " + apartmentNumber + "):\n\t— Цена: " + price + " р/сутки\n\t— Время заселения/выселения: " + checkInTime + additionsHeader + String.join(", ", additionsList);
    }
}