package org.course;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Hotel[] hotels = new Hotel[2];
        HotelFactory factory = new HotelFactory();
        hotels[0] = factory.createHotel(HotelFactory.hotelName.Mama);
        hotels[1] = factory.createHotel(HotelFactory.hotelName.Shashlyk);
        Scanner in = new Scanner(System.in);
        System.out.println("введите количество гостей: ");
        try {
            int testTru = in.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число число");
            return;
        }
        Scanner in2 = new Scanner(System.in);
        System.out.println("введите название отеля: ");
        int peopleNumber = in.nextInt();
        String inHotelName = in2.nextLine();
        System.out.println("Вы ищите отель " + inHotelName + " для " + peopleNumber + " чел.");
        for (int i = 0; i < hotels.length; i++) {
            if (!inHotelName.equalsIgnoreCase(hotels[i].getName())) {

                if (i + 1 < hotels.length) {
                    System.out.println("Отель " + hotels[i].getName() + " Вам не подходит. Проверяю следующий отель...");
                } else {
                    System.out.println("Отель " + hotels[i].getName() + " Вам не подходит.");
                    System.out.println("Отели по Вашему запросу не найдены");
                }
            } else {
                for (int j = 0; j < hotels[i].getRooms().length; j++) {
                    if (peopleNumber <= hotels[i].getRooms()[j].capacity) {
                        System.out.println("Отель: " + hotels[i].getName());
                        System.out.println("Вам подходит номер: " + hotels[i].getRooms()[j]);
                    } else {
                        System.out.println("В отеле " + hotels[i].getName() + " нет такого большого номера");
                        break;
                    }
                }
            }
        }
    }
}


