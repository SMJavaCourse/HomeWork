package org.course;

import constructors.HotelFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.course.Hotel.*;

public class Task3 {
    public static void main(String[] args) {
        Hotel firstHotel = HotelFactory.getInstance().createHotel("У мамы лучше");
        Hotel secondHotel = HotelFactory.getInstance().createHotel("Шашлычок");
        Hotel[] hotels = {firstHotel, secondHotel};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Поиск лучших номеров!\nВведите наименование отеля:");
                String hotelsName = scanner.nextLine().trim();
                if ("exit".equalsIgnoreCase(hotelsName) || "выход".equalsIgnoreCase(hotelsName)) {
                    return;
                }
                if (StringUtils.isBlank(hotelsName)) {
                    continue;
                }
                System.out.println("Введите количество гостей:");
                int inputNumPeople = scanner.nextInt();
                Hotel foundHotel = search(hotelsName, hotels);
                Apartment[] foundApartments = searchRoom(inputNumPeople, foundHotel);
                Hotel.printApartments(foundApartments);
                break;
            } catch (NullPointerException e) {
                System.out.println("Отель не найден!\n");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Количество гостей это число, повторите ввод.");
                break;
            }
        }
    }
}
