package org.course;

import org.course.exception.HotelFactoryException;
import org.course.utils.CommandsEnum;
import org.course.utils.HotelFactory;
import org.course.utils.SearchDTO;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.course.utils.FindHelper.hotelFinderString;
import static org.course.utils.ScannerCheck.validator;

public class Task3 {

    public static void main(String[] args) {

        HotelFactory factory = HotelFactory.getInstance();
        ArrayList<Hotel> hotels = new ArrayList<>();
        Map<String, Hotel> hotelStreamByName;

        try {
            hotels.add(factory.createHotel("У мамы лучше"));
            hotels.add(factory.createHotel("Шашлычок"));
            for (Hotel hotel : hotels) {
                System.out.println("\n" + hotel.toString());
            }
            hotelStreamByName = hotels.stream().collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity()));
            System.out.println("======================= Поиск вободных номеров ========================\n" +
                    "введите запрос в формате \"N\" или \"N \u00ABНазвание отеля\u00BB\", где N - количество гостей:");
            Scanner in = new Scanner((System.in));
            boolean exit = true;

            while (exit) {
                SearchDTO validateInput = validator(in.nextLine().trim());

                if (CommandsEnum.EXIT.name().equalsIgnoreCase(validateInput.getCommand())){
                    exit = false;
                } else if (validateInput.getErrorMessage() != null){
                    System.out.println(validateInput.getErrorMessage());
                } else {
                    System.out.println(hotelFinderString(validateInput.getNameOfHotel(), validateInput.getCommand(), validateInput.getNumberOfGuests(), hotelStreamByName));
                }
            }
            in.close();
        } catch (HotelFactoryException e) {
            System.out.println(e.getMessage() + "\nВыход из программы");
            System.exit(0);
        }
    }
}
