package org.course;

public class Hotel {
    private String name;
    private Apartment[] apartments;


    public Hotel(String name, Apartment[] apartments) {
        this.name = name;
        this.apartments = apartments;
    }

    public void print(){
        System.out.println("Отель: " + name);
        System.out.println("Количество номеров: " + apartments.length);
        System.out.println("Номера:");
        for (int i =0; i< apartments.length; i++)
            apartments[i].print();
        }
}