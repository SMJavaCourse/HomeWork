package org.course;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private Apartment[] apartments;
    private String startTime;

    public Hotel(String name, String startTime,Apartment[] apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public Apartment[] getRooms() {
        return apartments;
    }

    public String getStartTime() {
        return startTime;
    }

    public void soutTitle(String name, int numberOfApartments) {
        System.out.println("Отель \"" + name + "\"");
        System.out.println("Количество номеров: " + numberOfApartments);
        System.out.println("Номера:");
    }

    public void soutRooms(String startTime,Apartment[] apartments, int numberOfApartments) {
        for (int i = 0; i < numberOfApartments; i++) {

            System.out.println("\t\u2219 " + apartments[i].getNamesForNumberOfRooms(apartments[i].getNumberOfRooms()) +
                    " (комната номер " + apartments[i].getRoomNumber() + "):");
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
                if (apartments[i].getNumberOfRooms() == 3) {
                    arrayOfServices.add("джакузи");
                }
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
