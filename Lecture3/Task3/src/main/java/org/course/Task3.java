package org.course;

import org.course.exception.HotelFactoryException;
import org.course.constructors.HotelFactory;
import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;
import static org.course.Hotel.findHotel;

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
        } catch (HotelFactoryException e) {
            System.out.println(e.getMessage() + "\nВыход из программы");
            System.exit(0);
        } catch (NullPointerException e) {
            System.out.println("Отели не созданы, нечего выводить." + "\nВыход из программы");
            System.exit(0);
        }

        System.out.println("======================= Поиск вободных номеров ========================\n" +
                "введите запрос в формате \"N\" или \"N \u00ABНазвание отеля\u00BB\", где N - количество гостей:");

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
                int firstSpaceIndex = input.trim().indexOf(" ");
                try {
                    if (firstSpaceIndex == -1) {
                        System.out.println(findHotel(hotels, null,Integer.parseInt(input.trim())) + "\nЕщё один поиск:");
                        continue;
                    }
                    int numberOfGuests = Integer.parseInt(input.substring(0, firstSpaceIndex));
                    System.out.println(findHotel(hotels, input.substring(firstSpaceIndex+1), numberOfGuests) + "\nПовторите ввод:");
                } catch (NumberFormatException e) {
                    System.out.println("Количество гостей это число, повторите ввод:");
                }
            }
        }
    }
}
