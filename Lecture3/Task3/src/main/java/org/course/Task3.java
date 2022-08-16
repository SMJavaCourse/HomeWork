package org.course;

import org.course.exception.HotelFactoryException;
import org.course.utils.CommandsEnum;
import org.course.utils.Hotel;
import org.course.utils.HotelFactory;
import org.course.utils.SearchDTO;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.course.utils.FindHelper.hotelFinderStringStream;
import static org.course.utils.ScannerCheck.validator;

public class Task3 {

    public static void main(String[] args) {

        HotelFactory factory = HotelFactory.getInstance();
        ArrayList<Hotel> hotels = new ArrayList<>();

        try {
            hotels.add(factory.createHotel("У мамы лучше"));
            hotels.add(factory.createHotel("Шашлычок"));

            System.out.println("\n" +
                    hotels
                            .stream()
                            .map(Hotel::toStringTemp)
                            .collect(Collectors.joining("\n"))
                    + "\n============================ Поиск вободных номеров =============================\n" +
                    "введите запрос в формате \"N\" или \"N \u00ABНазвание отеля\u00BB\", где N - количество гостей:");

            Map<String, Hotel> hotelByName = hotels
                    .stream()
                    .collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity()));

            Scanner in = new Scanner((System.in));
            boolean exit = true;

            while (exit) {
                SearchDTO validateInput = validator(in.nextLine().trim());

                if (CommandsEnum.EXIT.name().equalsIgnoreCase(validateInput.getCommand())) {
                    exit = false;
                } else if (validateInput.getErrorMessage() != null) {
                    System.out.println(validateInput.getErrorMessage());
                } else {
                    System.out.println(hotelFinderStringStream(validateInput.getNameOfHotel(), validateInput.getCommand(), validateInput.getNumberOfGuests(), hotelByName)
                    );
                }
            }
            in.close();
        } catch (HotelFactoryException e) {
            System.out.println(e.getMessage() + "\nВыход из программы");
            System.exit(0);
        }
    }
}
