package org.course;

import org.course.Factory.HotelFactory;

public class Apartment {
//    private String name;
    private final int numberOfApart;
    private final int rooms;
    private final float price;
    private final String checkInTime;
    private final int capacity;

    public boolean isBalcony;
    public boolean isCleaning;
    public boolean isInternet;
    public boolean isCooling;
    public boolean isGrillInNumber;


    public int getCapacity() {
        return capacity;
    }

    public Apartment(int num, int rooms, float price, String checkInTime, int people, boolean isBalcony, boolean isCleaning, boolean isInternet, boolean isCooling, boolean isGrillInNumber) {
        this.numberOfApart = num;
        this.rooms = rooms;
        this.price = price;
        this.checkInTime = checkInTime;
        this.capacity = people;
        this.isBalcony = isBalcony;
        this.isCleaning = isCleaning;
        this.isInternet = isInternet;
        this.isCooling = isCooling;
        this.isGrillInNumber = isGrillInNumber;
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
        String s = "    Дополнительные услуги: ";

        if (isBalcony) {
            s = s + "балкон, ";

        }
        if (isCleaning) {
            s = s + "уборка номера, ";

        }
        if (isInternet) {
            s = s + "интернет, ";

        }
        if (isCooling) {
            s = s + "кондиционер, ";

        }
        if (isGrillInNumber) {
            s = s + "шашлычок в номер, ";

        }
        System.out.println(s);
    }
}