package org.course;

import java.util.ArrayList;

public interface Sout {
    default void soutTitle(String name, int numberOfApartments) {
        System.out.println("Отель \"" + name + "\"");
        System.out.println("Количество номеров: " + numberOfApartments);
        System.out.println("Номера:" + "\n");
    }

    default void soutRooms(Apartment[] apartments, int numberOfApartments) {
        for (int i = 0; i < numberOfApartments; i++) {
            ArrayList<String> array = new ArrayList<>();
            System.out.println("\t\u2219 " + apartments[i].getNumberOfRooms() + " (комната номер " + apartments[i].getRoomNumber() + "):");
            System.out.println("\t\t\u25e6 " + "Цена: " + apartments[i].getPrice() + " р/сутки");
            System.out.println("\t\t\u25e6 " + "Время заселение/выселения: " + apartments[i].getStartTime());
            System.out.print("\t\t\u25e6 " + "Дополнительные услуги: ");
            if (apartments[i].getBalcony() != null) {
                array.add(apartments[i].getBalcony());
            }
            if (apartments[i].getCleaning() != null) {
                array.add(apartments[i].getCleaning());
            }
            if (apartments[i].getInternet() != null) {
                array.add(apartments[i].getInternet());
            }
            if (apartments[i].getConditioner() != null) {
                array.add(apartments[i].getConditioner());
            }
            if (apartments[i].getMeat() != null) {
                array.add(apartments[i].getMeat());
            }
            for (int j = 0; j < array.size(); j++) {
                System.out.print(array.get(j));
                if (j < array.size()-1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

    }


}