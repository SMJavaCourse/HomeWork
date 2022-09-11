package org.course;

import org.apache.commons.lang3.StringUtils;
import org.course.Factory.HotelFactory;

import java.util.*;

import static org.course.Hotel.*;

public class Task3 {
    public static void main(String[] args) {
        Hotel momHotel = HotelFactory.getInstance().createHotel("У мамы лучше");
        Hotel grillHotel = HotelFactory.getInstance().createHotel("оШашлычок");
        List<Hotel> hotels = List.of(momHotel, grillHotel);
        Map<String, Hotel> hotelsByName = toHotelsByNameMap(hotels);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("""

                        Поиск свободных номеров
                        Введите запрос в формате: "N" или "N Название отеля",\s
                        где N - количество гостей:""");
                String input = scanner.nextLine().trim();
                if (":q!".equalsIgnoreCase(input) || "выход".equalsIgnoreCase(input)) {
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
                    int numberOfHotelsFound = 0;
                    int numFoundApartments = 0;
                    String foundHotelName;
                    for (Hotel hotel : hotels) {
                        List<Apartment> foundApartments = hotel.searchRoom(numberOfGuests);
                        if (foundApartments.size() != 0) {
                            foundHotelName = hotel.getName();
                            numFoundApartments++;
                            numberOfHotelsFound += 1;
                            System.out.println("\nОтель \u00AB" + foundHotelName + "\u00BB");
                            printApartments(foundApartments);
                        }
                        if (numFoundApartments == 0) {
                            System.out.println("Подходящих номеров не найдено=(");
                            break;
                        }
                    }
                    System.out.println("\n-Количество найденных отелей: " + numberOfHotelsFound);
                } else {
                    if (numberOfGuests <= 0) {
                        System.out.println("Введенное количество гостей должно быть больше нуля\n");
                        continue;
                    }
                    Hotel foundHotel = search(hotelName, hotelsByName);
                    if (foundHotel == null) {
                        System.out.println("Отель не существует!");
                        continue;
                    } else {
                        System.out.println("Для вас найден отель " + "\n\u00AB" + foundHotel.getName() + "\u00BB\n");
                    }
                    List<Apartment> foundApartments = foundHotel.searchRoom(numberOfGuests);
                    printApartments(foundApartments);
                }
            } catch (NullPointerException e) {
                System.out.println("Отель не найден!\n");
//                break;
//            } catch (InputMismatchException e) {
//                System.out.println("Количество гостей это число, повторите ввод:");
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("Количество гостей это число, повторите ввод:");
            } catch (Throwable e) {
                System.out.println("Message: " + e.getMessage() + "Количество гостей это число, повторите ввод:" +"\nError code: \n" + Arrays.toString(e.getStackTrace()));
//                myExceptions.printStackTrace();
            }
        }
    }

    private static String getHotelName(List<String> inputs) {
        if (inputs.size() <= 1) {
            return null;
        }
        StringBuilder hotelName = new StringBuilder();
        for (int i = 1; i < inputs.size(); i++) {
            hotelName.append(" ").append(inputs.get(i));
        }
        return hotelName.toString().trim();
    }
}