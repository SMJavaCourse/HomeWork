package org.course;

import constructors.HotelFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.course.Hotel.*;

public class Task3 {
    public static void main(String[] args) {
        Hotel firstHotel = HotelFactory.getInstance().createHotel("У мамы лучше");
        Hotel secondHotel = HotelFactory.getInstance().createHotel("Шашлычок");
        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(secondHotel);
        hotels.add(firstHotel);
//        Map<String, Hotel> nameOfHotels = hotelNameToMap(hotels);
//        nameOfHotels.put(firstHotel.getName(), firstHotel);
//        nameOfHotels.put(secondHotel.getName(), secondHotel);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\n\uD83C\uDF88" + " Поиск свободных номеров " + "\uD83C\uDF88" +
                        "\nВведите запрос в формате: \"N\" или \"N \u00ABНазвание отеля\u00BB\", \nгде N - количество гостей:");
                String input = scanner.nextLine().trim();
                if ("exit".equalsIgnoreCase(input) || "выход".equalsIgnoreCase(input)) {
                    return;
                }
                if (StringUtils.isBlank(input)) {
                    continue;
                }
                List<String> inputAll = List.of(input.split(" "));
                int numberOfGuests = Integer.parseInt(inputAll.get(0));
                String hotelName = getHotelName(inputAll);
                if (hotelName == null) {
                    if (numberOfGuests <= 0) {
                        System.out.println("Введенное количество гостей должно быть больше нуля");
                        continue;
                    }

//                var a = inputAll.stream()
//                        .allMatch(x -> hotelName == null && numberOfGuests <= 0);
//                System.out.println("Введенное количество гостей должно быть больше нуля");
//                continue;

                    int numberOfHotelsFound = 0;
                    int numFoundApartments = 0;
                    String foundHotelName = "";
                    for (Hotel hotel : hotels) {
                        List<Apartment> foundApartments = hotel.searchRoom(numberOfGuests);
                        if (foundApartments.size() != 0) {
                            foundHotelName = hotel.getName();
                            numFoundApartments++;
                            numberOfHotelsFound += 1;
                            System.out.println("\nОтель \"" + foundHotelName + "\"" + "\n");
                            Hotel.printApartments(foundApartments);
                        }
                        if (numFoundApartments == 0) {
                            System.out.println("Подходящих номеров не найдено");
                        }
                    }
                    System.out.println("\nКоличество найденных отелей: " + numberOfHotelsFound + "\n");
                } else {
                    if (numberOfGuests <= 0) {
                        System.out.println("Введенное количество гостей должно быть больше нуля\n");
                        continue;
                    }
                    Hotel foundHotel = search(hotelName, hotels);
                    if (foundHotel == null) {
                        System.out.println("Отель не существует!\n");
                        continue;
                    }
                    List<Apartment> foundApartments = foundHotel.searchRoom(numberOfGuests);
                    Hotel.printApartments(foundApartments);
                }
            } catch (NullPointerException e) {
                System.out.println("Отель не найден!\n");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Количество гостей это число, повторите ввод.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Количество гостей это число, повторите ввод:");
            }
        }
    }

    private static String getHotelName(List<String> inputs) {
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