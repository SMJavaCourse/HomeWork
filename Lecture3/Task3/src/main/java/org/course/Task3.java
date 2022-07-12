package org.course;

import org.apache.commons.lang3.StringUtils;
import org.course.exception.BookingException;
import org.course.factory.HotelFactory;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите название отеля:");
                String hotelsName = scanner.nextLine();
                if (hotelsName.equalsIgnoreCase("Выйти")){
                    return;
                }
                System.out.println("Введите число человек:");
                int numberOfPeople = Integer.parseInt(scanner.nextLine());
                Hotel firstHotel = HotelFactory.getInstance().createHotel("У мамы лучше");
                Hotel secondHotel = HotelFactory.getInstance().createHotel("Шашлычок");
                Hotel[] hotels = {firstHotel, secondHotel};
                System.out.println(Hotel.findRooms(hotels, hotelsName, numberOfPeople));
            } catch (BookingException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Введено неверное значение в поле \"Введите число человек\"");
            }
            System.out.print(System.lineSeparator());
        }
    }
}

