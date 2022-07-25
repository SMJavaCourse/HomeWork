package org.course;

import org.course.features.Feature;

import java.util.List;

public class Apartment {
    private static final String ONE_ROOM = "Однокомнатный номер";
    private static final String TWO_ROOM = "Двухкомнатный номер";
    private static final String THREE_ROOM = "Трехкомнатный номер";
    private final int apartmentNumber;
    private final List<Feature> features;
    private final int numberOfRooms;
    private final int numberOfPeople;
    protected double price;

    public Apartment(int numberOfRooms, double price, int apartmentNumber, int numberOfPeople, List<Feature> features) {
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.apartmentNumber = apartmentNumber;
        this.numberOfPeople = numberOfPeople;
        this.features = features;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public double getPrice() {
        return this.price;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public String getNameOfApartment() {
        switch (numberOfRooms) {
            case 1:
                return ONE_ROOM;
            case 2:
                return TWO_ROOM;
            case 3:
                return THREE_ROOM;
            default:
                throw new RuntimeException("такого нет");
        }
    }

    @Override
    public String toString() {
        String text =
                "- " + getNameOfApartment() + " (комната номер: " + getApartmentNumber() + ")" + System.lineSeparator() +
                        " - Цена: " + getPrice() + " (р/сутки)" + System.lineSeparator() +
                        " - количество человек в номере: " + getNumberOfPeople() + System.lineSeparator() +
                        " - Дополнительные услуги: ";
        if (features.size() == 0) {
            text += "дополнительные услуги отсутствуют";
        } else {
            for (int i = 0; i < features.size(); i++) {
                if (i != features.size() - 1) {
                    text += features.get(i).getName() + ", ";
                } else {
                    text += features.get(i).getName();
                }
            }
        }
        return text;
    }

}

