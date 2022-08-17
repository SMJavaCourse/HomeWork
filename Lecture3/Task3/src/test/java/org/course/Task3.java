package org.course;

import org.course.dto.SearchInput;
import org.course.entity.CommandsEnum;
import org.course.entity.Hotel;
import org.course.exception.HotelFactoryException;
import org.course.service.HotelFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.course.service.FindHelper.hotelFinderString;
import static org.course.service.ValidationInput.validator;

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
                            .map(Hotel::toString)
                            .collect(Collectors.joining("\n"))
                    + "\n============================ Поиск вободных номеров =============================\n" +
                    "введите запрос в формате \"N\" или \"N \u00ABНазвание отеля\u00BB\", где N - количество гостей:");

            Map<String, Hotel> hotelByName = hotels
                    .stream()
                    .collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity()));

            Scanner in = new Scanner((System.in));
            boolean exit = true;

            while (exit) {
                SearchInput validateInput = validator(in.nextLine().trim());

                if (CommandsEnum.EXIT.name().equalsIgnoreCase(validateInput.getCommand())) {
                    exit = false;
                } else if (validateInput.getErrorMessage() != null) {
                    System.out.println(validateInput.getErrorMessage());
                } else {
                    System.out.println(hotelFinderString(validateInput.getNameOfHotel(), validateInput.getCommand(), validateInput.getNumberOfGuests(), hotelByName)
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
