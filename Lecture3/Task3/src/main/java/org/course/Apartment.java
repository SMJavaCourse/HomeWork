package org.course;

import java.util.ArrayList;

public abstract class Apartment {
    private String name;
    private int price;
    private int numberOfRoom;
    private boolean balcony;
    private boolean cleaning;
    private boolean internet;
    private boolean conditioner;
    private boolean meat;
    private boolean jacuzzi;

    public Apartment(int numberOfRoom, int price) {
        this.numberOfRoom = numberOfRoom;
        this.price = price;
    }

    public boolean isBalcony() {
        return balcony;
    }
    public boolean isCleaning() {
        return cleaning;
    }
    public boolean isInternet() {
        return internet;
    }
    public boolean isConditioner() {
        return conditioner;
    }
    public boolean isMeat() {
        return meat;
    }
    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }
    public void setCleaning(boolean cleaning) {
        this.cleaning = cleaning;
    }
    public void setInternet(boolean internet) {
        this.internet = internet;
    }
    public void setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
    }
    public void setMeat(boolean meat) {
        this.meat = meat;
    }
    public boolean setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
        return jacuzzi;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }
    public int getPrice() {
        return price;
    }
    public String getName(){
        return name;
    }

    public static void soutRooms(String startTime,Apartment[] apartments, int numberOfApartments) {
        for (int i = 0; i < numberOfApartments; i++) {
            System.out.println("\t\u2219 " + apartments[i].getName() +
                    " (комната номер " + apartments[i].getNumberOfRoom() + "):");
            System.out.println("\t\t\u25e6 " + "Цена: " + apartments[i].getPrice() + " р/сутки");
            System.out.println("\t\t\u25e6 " + "Время заселение/выселения: " + startTime);
            System.out.print("\t\t\u25e6 " + "Дополнительные услуги: ");

            ArrayList<String> arrayOfServices = new ArrayList<>();
            if (apartments[i].isBalcony()) {
                arrayOfServices.add("балкон");
            }
            if (apartments[i].isCleaning()) {
                arrayOfServices.add("уборка номера");
            }
            if (apartments[i].isInternet()) {
                arrayOfServices.add("интернет");
            }
            if (apartments[i].isConditioner()) {
                arrayOfServices.add("кондиционер");
            }
            if (apartments[i].isMeat()) {
                arrayOfServices.add("шашлычок");
            }
            if (apartments[i].isJacuzzi()) {
                arrayOfServices.add("джакузи");
            }
            for (int j = 0; j < arrayOfServices.size(); j++) {
                System.out.print(arrayOfServices.get(j));
                if (j < arrayOfServices.size()-1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

    }
}
