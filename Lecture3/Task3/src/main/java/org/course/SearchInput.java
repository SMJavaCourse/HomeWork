package org.course;

import constructors.HotelFactory;
import helper.SearchHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchInput {
    public static void main(String[] args) {
        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(HotelFactory.getInstance().createHotel("У мамы лучше"));
        hotels.add(HotelFactory.getInstance().createHotel("Шашлычок"));
        String commandService = null;
        int numberOfGuests = 0;

        Map<String, Hotel> nameOfHotels = hotels //создаем мапу с отелями, гду key - имя отеля, value сам объект отеля
                .stream()
                .collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity())); //кладем в мапу key - имя отеля, value - бъект отеля

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\uD83C\uDF88" + " Поиск свободных номеров " + "\uD83C\uDF88" +
                    "\nВведите запрос в формате: \"N\" или \"N \u00ABНазвание отеля\u00BB\", \nгде N - количество гостей:");

            String input = scanner.nextLine().trim(); //ввод значений
            List<String> inputAll = List.of(input.split(" "));//вырезаем стрингу из ввода и режем на отдельные слова
            if (inputAll.get(0).equals("удобства")){
                commandService = inputAll.get(0);
            }
            else {
                numberOfGuests = Integer.parseInt(inputAll.get(0)); //распарсиваем количество введенных гостей
            }
                String hotelName = getHotelName(inputAll); //получаем имя отеля выполнив метод getHotelName
                System.out.println(SearchHelper.searchHotelString(hotelName, commandService, numberOfGuests, nameOfHotels));
            }
    }
        private static String getHotelName(List<String> inputs) { //склеиваем имя отеля из введенных слов
        if (inputs.size() <= 1) {
            return null;
        }
        String hotelName = "";
        for (int i = 1; i < inputs.size(); i++) {
            hotelName = hotelName + " " + inputs.get(i);
        }
        return hotelName.trim();
    }
}

