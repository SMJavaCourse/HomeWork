package org.course;

import org.course.dao.HotelRepository;
import org.course.dto.SearchInput;
import org.course.entity.CommandsEnum;

import java.util.Scanner;

import static org.course.service.ValidationInput.validator;

public class Task3 {

    public static void main(String[] args) {
        HotelRepository hotelRepository = new HotelRepository();

        System.out.println("\n============================ Поиск вободных номеров =============================\n" +
                "введите запрос в формате \"N\" или \"N \u00ABНазвание отеля\u00BB\", где N - количество гостей:");

        Scanner in = new Scanner((System.in));
        boolean exit = true;

        while (exit) {
            SearchInput validateInput = validator(in.nextLine().trim());
            if (CommandsEnum.EXIT.name().equalsIgnoreCase(validateInput.getCommand())) {
                exit = false;
            } else if (validateInput.getErrorMessage() != null) {
                System.out.println(validateInput.getErrorMessage());
            } else {
                System.out.println(hotelRepository.hotelFinder(
                        validateInput.getNameOfHotel(),
                        validateInput.getCommand(),
                        validateInput.getNumberOfGuests()));
            }
        }
        in.close();
    }
}
