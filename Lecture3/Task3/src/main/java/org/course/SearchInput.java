package org.course;

import constructors.HotelFactory;
import dto.Command;
import dto.MainData;
import exeption.HotelNotExistException;
import exeption.ValidateInput;
import helper.SearchHelper;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchInput {
    public static void main(String[] args) {
        ArrayList<Hotel> hotels = new ArrayList<>();

        try {
            hotels.add(HotelFactory.getInstance().createHotel("У мамы лучше"));
            hotels.add(HotelFactory.getInstance().createHotel("Шашлычок"));


            Map<String, Hotel> nameOfHotels = hotels //создаем мапу с отелями, гду key - имя отеля, value сам объект отеля
                    .stream()
                    .collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity())); //кладем в мапу key - имя отеля, value - бъект отеля

            System.out.println("\n\uD83C\uDF88" + " Поиск свободных номеров " + "\uD83C\uDF88" +
                    "\nВведите запрос в формате: \"N\" или \"N \u00ABНазвание отеля\u00BB\", \nгде N - количество гостей:");


            Scanner scanner = new Scanner(System.in);
            boolean exit = true;

            while (exit) {
                MainData input = ValidateInput.validateInput(scanner.nextLine().trim()); //ввод значений

                if (Command.EXIT.name.equalsIgnoreCase(input.getCommandInput())) {
                    exit = false;
                } else if (input.getErrorMessage() != null) {
                    System.out.println(input.getErrorMessage());
                } else {
                    System.out.println(SearchHelper.searchHotelString(input.getNameOfHotels(), input.getCommandInput(), input.getNumberOfGuests(), nameOfHotels));
                }
            }
            scanner.close();
        } catch (HotelNotExistException e) {
            System.out.println(e.getMessage() + "\nВыход");
            System.exit(0);
        }
    }
}