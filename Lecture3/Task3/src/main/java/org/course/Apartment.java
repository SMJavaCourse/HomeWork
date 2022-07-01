package org.course;

public abstract class Apartment {
    private int rooms;
    private int price;
    private int capacity;
    private String checkInTime = Hotel.getCheckInTime();
    private int apartmentNumber;
    private String[] additions;

    public Apartment(int rooms, int price, int capacity, int apartmentNumber, String[] additions) {
        this.rooms = rooms;
        this.price = price;
        this.capacity = capacity;
        this.apartmentNumber = apartmentNumber;
        this.additions = additions;
    }

//    Вывод:
    void roomsNumber() {
        switch (rooms) {
            case 1 -> System.out.print("\n— Однокомнатный номер");
            case 2 -> System.out.print("\n— Двухкомнатный номер");
            case 3 -> System.out.print("\n— Трехкомнатный номер");
        }
        System.out.print(" (комната номер " + apartmentNumber + "):");
    }

    void price() {
        System.out.print("\n\t— Цена: " + price + " р/сутки");
    }

//    void capacity() {
//        System.out.print("\t— Вместимость: " + capacity);
//        int lastTwoNumbers = capacity % 100;
//        int lastNumber = capacity % 10;
//        if (lastTwoNumbers >= 12 && lastTwoNumbers <= 14) {
//            System.out.println(" человек");
//        } else {
//            if (lastNumber >= 2 && lastNumber <= 4) {
//                System.out.println(" человека");
//            } else
//                System.out.println(" человек");
//        }
//    }

    void checkInTime() {
        System.out.print("\n\t— Время заселения/выселения: " + checkInTime);
    }

    void additions() {
        if (additions != null) {
            System.out.print("\n\t— Дополнительные услуги: ");
            for (int i = 0; i < additions.length; i++) {
                if(i == 0) {
                    System.out.print(additions[i]);
                } else System.out.print(", " + additions[i]);
            }
        }
    }

    void apartmentInfo() {
        roomsNumber();
        price();
//        Capacity();
        checkInTime();
        additions();
    }
}