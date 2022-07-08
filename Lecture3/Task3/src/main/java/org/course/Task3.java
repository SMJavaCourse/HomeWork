package org.course;

import org.course.exception.MyException;
import org.course.factory.HotelFactory;
import org.course.services.*;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static org.course.Hotel.findHotels;

public class Task3 {

    public static void main(String[] args) {

        Apartment[] allRoomsInHotel1 = new Apartment[5];
        allRoomsInHotel1[0] = new Apartment(1, 10, 1000, 2, new Balcony());
        allRoomsInHotel1[1] = new Apartment(2, 20, 3000, 4, new Balcony(),
                new Cleaning(), new Internet(512), new Conditioner());
        allRoomsInHotel1[2] = new Apartment(2, 30, 3000, 4, new Balcony(),
                new Cleaning(), new Internet(), new Conditioner());
        allRoomsInHotel1[3] = new Apartment(3, 40, 2500, 6);
        allRoomsInHotel1[4] = new Apartment(3, 50, 3500, 6, new Balcony(),
                new Internet(), new Jacuzzi());

        Apartment[] allRoomsInHotel2 = new Apartment[3];
        allRoomsInHotel2[0] = new Apartment(1, 11, 1000, 2, new Meat());
        allRoomsInHotel2[1] = new Apartment(2, 22, 2000, 4, new Balcony(),
                new Cleaning());
        allRoomsInHotel2[2] = new Apartment(3, 33, 4000, 6, new Cleaning(),
                new Jacuzzi());

        HotelFactory factory = new HotelFactory();

        System.out.println("");

        Hotel[] hotels = new Hotel[2];
        hotels[0] = factory.createHotel("У мамы лучше1", allRoomsInHotel1);
        hotels[1] = factory.createHotel("", allRoomsInHotel2);

        System.out.println(hotels[0].toString());
        System.out.println(hotels[1].toString());

        Scanner in = new Scanner((System.in));
        boolean exit = false;
        System.out.println("Поиск вободных номеров:\nвведите запрос в формате \u00ABНазвание отеля N\u00BB, где N - количество гостей:");
        while (!exit) {
            String input = in.nextLine().trim();
            if (StringUtils.isBlank(input)) {
                System.out.println("Пустая строка. Повторите ввод");
                continue;
            }
            if ("exit".equalsIgnoreCase(input)) {
                exit = true;
            } else {
                String[] command = input.split(" ");
                StringBuilder nameOfHotel = new StringBuilder();
                for (int i = 0; i < command.length - 1; i++) {
                    nameOfHotel.append(command[i]).append(" ");
                }
                try {
                    int numberOfGuests = Integer.parseInt(command[command.length - 1]);
                    System.out.println(findHotels(hotels, nameOfHotel.toString().trim(), numberOfGuests));
                } catch (NumberFormatException e) {
                    System.out.println("Количество гостей это число, повторите ввод");
                }
                catch (NullPointerException e) {
                    System.out.println("Отели не созданы, негде искать");
                    exit = true;
                }
            }
        }
    }
}
