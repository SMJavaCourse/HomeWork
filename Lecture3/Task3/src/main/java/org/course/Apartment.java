package org.course;

import org.course.features.Feature;

public abstract class Apartment {
    protected double price;
    private final int numberOfRoom;
    private final Feature[] features;
    public Apartment(double price, int numberOfRoom, Feature[] features) {
        this.price = price;
        this.numberOfRoom = numberOfRoom;
        this.features = features;
    }
    public Feature[] getFeatures() {
        return this.features;
    }
    public double getPrice(){
        return this.price;
    }

    public int getNumberOfRoom(){
        return numberOfRoom;
    }

    public abstract String getNameOfApartment();
    @Override
    public String toString() {
        String text =
                "- " + getNameOfApartment() + " (комната номер: " + getNumberOfRoom() + ")"+ System.lineSeparator() +
                " - Цена: " + getPrice() + " (р/сутки)" + System.lineSeparator() +
                " - Дополнительные услуги: ";
        if (features.length == 0) {
            text += "дополнительные услуги отсутствуют";
        } else {
            for (int i = 0; i < features.length; i++) {
                if (i != features.length - 1) {
                    text += features[i].getName() + ", ";
                } else {
                    text += features[i].getName();
                }
            }
        }
        return text;
    }

}

