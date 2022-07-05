package org.course;

import org.course.services.Services;

public abstract class Apartment {
    private String name;
    private int price;
    private int numberOfRoom;
    private Services[] services;

    public Apartment(int numberOfRoom, int price, Services[] services) {
        this.numberOfRoom = numberOfRoom;
        this.price = price;
        this.services = services;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        String text = "\t\u2219 " + getName() +
                " (комната номер " + numberOfRoom + "):" + "\n" +
                "\t\t\u25e6 " + "Цена: " + price + "\n" +
                "\t\t\u25e6 " + "Дополнительные услуги: ";
        if (services.length == 0){
            text +="отсутствуют" + "\n";
        }
        else {
            for (int i = 0; i < services.length; i++) {
                text += services[i].getName();
                if (i + 1 < services.length) {
                    text +=", ";
                }
                else {
                    text +="\n";
                }
            }
        }
        return text;
    }
}
