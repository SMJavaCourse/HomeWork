//package org.course;
//
//import constructors.HotelFactory;
//import helper.SearchHelper;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class Task3 {
//    public static void main(String[] args) {
//        ArrayList<Hotel> hotels = new ArrayList<>();
//        hotels.add(HotelFactory.getInstance().createHotel("У мамы лучше"));
//        hotels.add(HotelFactory.getInstance().createHotel("Шашлычок"));
//        String commandName = "";
//
//        Map<String, Hotel> nameOfHotels = hotels //создаем мапу с отелями, гду key - имя отеля, value сам объект отеля
//                .stream()
//                .collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity())); //кладем в мапу key - имя отеля, value - бъект отеля
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            try {
//                System.out.println("\n\uD83C\uDF88" + " Поиск свободных номеров " + "\uD83C\uDF88" +
//                        "\nВведите запрос в формате: \"N\" или \"N \u00ABНазвание отеля\u00BB\", \nгде N - количество гостей:");
//
//                String input = scanner.nextLine().trim(); //ввод значений
//
//                if ("exit".equalsIgnoreCase(input) || "выход".equalsIgnoreCase(input)) { //проверка команды "выход"
//                    return;
//                }
//                if (StringUtils.isBlank(input)) {   //проверка на пустоту
//                    continue;
//                }
//
//                List<String> inputAll = List.of(input.split(" "));//вырезаем стрингу из ввода и режем на отдельные слова
//                int numberOfGuests = Integer.parseInt(inputAll.get(0)); //распарсиваем количество введенных гостей
//                String hotelName = getHotelName(inputAll); //получаем имя отеля выполнив метод getHotelName
//                if (numberOfGuests <= 0) { //проверяем что кол-во гостей больше 0
//                    System.out.println("Введенное количество гостей должно быть больше нуля\n");
//                    continue;
//                } else {
//                    System.out.println(SearchHelper.searchHotelString(hotelName, numberOfGuests, nameOfHotels));
//                }
//            } catch (RuntimeException e) {
//                System.out.println("Количество гостей это число, повторите ввод.");
//            }
//        }
//    }
//
//    private static String getHotelName(List<String> inputs) { //склеиваем имя отеля из введенных слов
//        if (inputs.size() <= 1) {
//            return null;
//        }
//        String hotelName = "";
//        for (int i = 1; i < inputs.size(); i++) {
//            hotelName = hotelName + " " + inputs.get(i);
//        }
//        return hotelName.trim();
//    }
//}