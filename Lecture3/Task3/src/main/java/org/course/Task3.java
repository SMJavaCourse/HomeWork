package org.course;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static List<Hotel> hotels;
    public static void main(String[] args) throws HotelException {
        // вывести по каждому из отелей:
        // общее количество номеров
        // список номеров с их описанием

        hotels = generateHotels();

//        Hotels.printHotelInfo(hotels);
//        Hotel.printAvailableApartmentByHotelName(hotels, "У мамы лучше", 4);
        // for test:
//        Hotel.printAvailableApartmentByHotelName(hotels, "У папы лучше", 4);
//        Hotel.printAvailableApartmentByHotelName(hotels, "У мамы лучше", 40);
//        Hotel.printAvailableApartmentByHotelName(new Hotel[0], "У мамы лучше", 4);
//        Hotel.printAvailableApartmentByHotelName(new Hotel[1], "У мамы лучше", 4);

        Scanner inputScanner = new Scanner(System.in);

        boolean continueApp = true;
        while(continueApp) {
            System.out.print("Please, input one of following command: " +
                    " | exit (to interrupt program) " +
                    " | info (to get info about all hotels)" +
                    " | find \"hotelName\" places (to find apartments by Hotel Name and Number Of Places) " +
                    "\nInput here: ");
            String value = inputScanner.nextLine();
            if (value == null) {
                System.out.println("Command cannot be null");
            } else {
                String[] commandWithArguments = value.trim().split(" ");
                if (commandWithArguments.length < 1) {
                    System.out.println("Command not found");
                } else {
                    switch (commandWithArguments[0]) {
                        case "exit":
                            System.out.println("Program has stopped...");
                            continueApp = false;
                            break;
                        case "info":
                            Hotels.printHotelInfo(hotels);
                            break;
                        case "find":
                            if (commandWithArguments.length == 3) {
                                Hotel.printAvailableApartmentByHotelName(hotels, commandWithArguments[1],
                                        Integer.valueOf(commandWithArguments[2]));
                            } else if (commandWithArguments.length > 3) {
                                Pattern pattern = Pattern.compile("[\\W]*\\W[\\s]");
                                Matcher matcher = pattern.matcher(value);
                                List<String> listMatches = new ArrayList<>();
                                while(matcher.find())
                                {
                                    listMatches.add(matcher.group(0));
                                }
                                var p = listMatches.get(0).trim().substring(0,1);
                                var param1 = listMatches.get(0).trim().substring(p.equals("\"") ? 1 : 0, p.equals("\"") ?
                                        listMatches.get(0).trim().length() - 1 : listMatches.get(0).trim().length());

                                Pattern pattern2 = Pattern.compile("[\\w]*\\d");
                                Matcher matcher2 = pattern2.matcher(value);
                                List<String> listMatches2 = new ArrayList<>();
                                while(matcher2.find())
                                {
                                    listMatches2.add(matcher2.group(0));
                                }
                                var param2 = listMatches2.get(0);

                                Hotel.printAvailableApartmentByHotelName(hotels, param1,
                                        Integer.valueOf(param2));
                            }
                            break;
                    }
                }
            }
        }
        inputScanner.close();

    }

    public static List<Hotel> generateHotels() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(HotelFactory.createHotel("У мамы лучше"));
        hotels.add(HotelFactory.createHotel("Шашлычок"));
        return hotels;
    }

}
