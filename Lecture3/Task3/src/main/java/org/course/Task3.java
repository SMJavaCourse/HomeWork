package org.course;

import org.course.exception.MyException;
import org.course.constructors.HotelFactory;
import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;
import static org.course.Hotel.findHotels;

public class Task3 {

    public static void main(String[] args) {

        System.out.println("");

        HotelFactory factory = HotelFactory.getInstance();
        Hotel[] hotels = new Hotel[2];
        try {
            hotels[0] = factory.createHotel("У мамы лучше");
            hotels[1] = factory.createHotel("Шашлычок");
            System.out.println(hotels[0].toString());
            System.out.println(hotels[1].toString());
        } catch (MyException e) {
            System.out.println(e.getTextException() + "\nВыход из программы");
            System.exit(0);
        } catch (NullPointerException e) {
            System.out.println("Отели не созданы, нечего выводить." + "\nВыход из программы");
            System.exit(0);
        }

        System.out.println("======================= Поиск вободных номеров ========================\n" +
                "введите запрос в формате \u00ABНазвание отеля N\u00BB, где N - количество гостей:");

        Scanner in = new Scanner((System.in));
        boolean exit = false;
        while (!exit) {
            String input = in.nextLine().trim();
            if (StringUtils.isBlank(input)) {
                System.out.println("Пустая строка. Повторите ввод");
                continue;
            }
            if ("exit".equalsIgnoreCase(input) || "выход".equalsIgnoreCase(input)) {
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
                    System.out.println("Количество гостей это число, повторите ввод:");
                }
            }
        }
    }
}
