package org.course;

import constructors.ApartBuilder;
import constructors.HotelFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

import static org.course.Hotel.search;
import static org.course.Hotel.searchRoom;

public class Task3 {
    public static void main(String[] args) {
        Hotel firstHotel = HotelFactory.getInstance().createHotel("У мамы лучше");
        Hotel secondHotel = HotelFactory.getInstance().createHotel("Шашлычок");
        Hotel[] hotels = {firstHotel, secondHotel};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Поиск лучших номеров!\nВведите наименование отеля:\n");
        boolean again = true;
        while (again) {
            String input = scanner.nextLine().trim();
            if (StringUtils.isBlank(input)) {
                System.out.println("Пустая строка");
                //again = false;
                continue;
            } else {
                Hotel foundHotel = search(input, hotels);
                if (foundHotel == null) {
                    System.out.println("Не нашел");
                } else {
                    System.out.println("Для вас найден отель" + " " + "\n\"" + foundHotel.getName() + "\"\n");
                }
                System.out.println("Введите количество гостей:");
                int inputNumPeople = scanner.nextInt();
                Apartment[] foundApartments = searchRoom(inputNumPeople, foundHotel);
                if (foundApartments == null) {
                    System.out.println("Не нашел");
                } else {
                    printApartments(foundApartments);
                }
            }
        }
    }


    public static void printApartments(Apartment[] apartments) {
        System.out.println("Количество аппартаментов:" + apartments.length);
        for (int i = 0; i < apartments.length; i++) {
            apartments[i].print();
        }
    }
}
