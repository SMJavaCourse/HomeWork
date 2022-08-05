package org.course;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static List<Hotel> hotels;
    public static void main(String[] args) throws HotelException, ParseException {
        // вывести по каждому из отелей:
        // общее количество номеров
        // список номеров с их описанием

        hotels = generateHotels();

        Hotels.printHotelInfo(hotels);
//        var s = Hotel.getAvailableApartments(hotels, "У мамы лучше", 4);
//        var ss = Hotel.getApartmentsByParam(hotels, 2);
//        System.out.println(ss);

//        System.out.println(Hotel.getApartmentsByParam(hotels, 6));
        Hotel.printAvailableApartmentByParams(hotels, 4);


        //TODO: переделать ввод с консоли,
        // посмотреть как можно в один стрим вытащить в список мап с ключем-имя отеля и значением-список апартаментов подходящих

        // for test:
//        Hotel.printAvailableApartmentByHotelName(hotels, "У папы лучше", 4);
//        Hotel.printAvailableApartmentByHotelName(hotels, "У мамы лучше", 40);
//        Hotel.printAvailableApartmentByHotelName(new Hotel[0], "У мамы лучше", 4);
//        Hotel.printAvailableApartmentByHotelName(new Hotel[1], "У мамы лучше", 4);

//        Scanner inputScanner = new Scanner(System.in);
//
//        boolean continueApp = true;
//        while(continueApp) {
//            System.out.print("Please, input one of following command: " +
//                    " | exit (to interrupt program) " +
//                    " | info (to get info about all hotels)" +
//                    " | find -n=\"hotelName\" -p=numberOfPlaces (to find apartments by Hotel Name and Number Of Places) " +
//                    "\nInput here: ");
//            String value = inputScanner.nextLine();
//            if (value == null) {
//                System.out.println("Command cannot be null");
//            } else {
//
////                Options options = new Options();
////                options.addOption(new Option("l", "language", true, "language"));
////                CommandLineParser commandLineParser = new DefaultParser();
////                CommandLine commandLine = commandLineParser.parse(options, args);
//
////                String[] commandWithArguments = value.trim().split(" ");
////                if (commandWithArguments.length < 1) {
////                    System.out.println("Command not found");
////                } else {
////                    switch (commandWithArguments[0]) {
////                        case "exit":
////                            System.out.println("Program has stopped...");
////                            continueApp = false;
////                            break;
////                        case "info":
////                            Hotels.printHotelInfo(hotels);
////                            break;
////                        case "find":
////                            Pattern pattern = Pattern.compile("[\\W]*\\W[\\s]");
////                            Matcher matcher = pattern.matcher(value);
////                            List<String> listMatches = new ArrayList<>();
////                            while(matcher.find())
////                            {
////                                listMatches.add(matcher.group(0));
////                            }
////                            var p = listMatches.get(0).trim().substring(0,1);
////                            var param1 = listMatches.get(0).trim().substring(p.equals("\"") ? 1 : 0, p.equals("\"") ?
////                                    listMatches.get(0).trim().length() - 1 : listMatches.get(0).trim().length());
////
////                            Pattern pattern2 = Pattern.compile("[\\w]*\\d");
////                            Matcher matcher2 = pattern2.matcher(value);
////                            List<String> listMatches2 = new ArrayList<>();
////                            while(matcher2.find())
////                            {
////                                listMatches2.add(matcher2.group(0));
////                            }
////                            var param2 = listMatches2.get(0);
////                            if (commandWithArguments.length == 3) {
////                                Hotel.printAvailableApartmentByParams(hotels, commandWithArguments[1],
////                                        Integer.valueOf(commandWithArguments[2]));
////                            } else if (commandWithArguments.length > 3) {
////
////
////                                Hotel.printAvailableApartmentByParams(hotels, param1,
////                                        Integer.valueOf(param2));
////                            } else if (commandWithArguments.length == 2 && isInteger(commandWithArguments[1])) {
//////                                Hotel.printAvailableApartmentByParams(hotels, Integer.valueOf(param2));
////                                System.out.println("FFF");
////                            }
////                            break;
////                    }
////                }
//            }
//        }
//        inputScanner.close();

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static List<Hotel> generateHotels() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(HotelFactory.createHotel("У мамы лучше"));
        hotels.add(HotelFactory.createHotel("Шашлычок"));
        return hotels;
    }

}
