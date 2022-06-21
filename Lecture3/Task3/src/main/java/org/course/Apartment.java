package org.course;

public abstract class Apartment {
    private int rooms;
    private int price;
    private int capacity;
    private String checkInTime = Hotel.getCheckInTime();
    private int apartmentNumber;
    private String additions;

    public Apartment(int rooms, int price, int capacity, int apartmentNumber) {
        this.rooms = rooms;
        this.price = price;
        this.capacity = capacity;
        this.apartmentNumber = apartmentNumber;
    }

    public void setAdditions(String additions) {
        this.additions = additions;
    }

//    Вывод:
    void RoomsNumber() {
        switch (rooms) {
            case 1 -> System.out.print("— Однокомнатный номер");
            case 2 -> System.out.print("— Двухкомнатный номер");
            case 3 -> System.out.print("— Трехкомнатный номер");
        }
        System.out.println(" (комната номер " + apartmentNumber + "):");
    }

    void Price() {
        System.out.println("\t— Цена: " + price + " р/сутки");
    }

    void Capacity() {
        System.out.print("\t— Вместимость: " + capacity);
        int lastTwoNumbers = capacity % 100;
        int lastNumber = capacity % 10;
        if (lastTwoNumbers >= 12 && lastTwoNumbers <= 14) {
            System.out.println(" человек");
        } else {
            if (lastNumber >= 2 && lastNumber <= 4) {
                System.out.println(" человека");
            } else
                System.out.println(" человек");
        }
    }
    void CheckInTime() {
        System.out.println("\t— Время заселения/выселения: " + checkInTime);
    }

    void Additions() {
        if (additions != null) {
            System.out.println("\t— Дополнительные услуги: " + additions);
        }
    }

    void ApartmentInfo() {
        RoomsNumber();
        Price();
        Capacity();
        CheckInTime();
        Additions();
    }
}