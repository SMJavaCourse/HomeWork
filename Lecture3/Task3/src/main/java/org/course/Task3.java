package org.course;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static HotelsRepo hotelsRepo = HotelsRepo.getInstance();
    public static void main(String[] args) throws HotelException, ParseException {
        // вывести по каждому из отелей:
        // общее количество номеров
        // список номеров с их описанием

        hotelsRepo.generateMoreHotels(); // нагенерить > 1000000 отелей для теста

        var time = new SearchTimeDemo();
        Hotel.printAvailableApartmentByParams(hotelsRepo, "У мамы лучше", 4);
        time.getMethodDuration();

        // for test (Task#3):
//        Hotel.printAvailableApartmentByParams(hotelsRepo, 4);
//        Hotel.printAvailableApartmentByHotelName(hotels, "У папы лучше", 4);
//        Hotel.printAvailableApartmentByHotelName(hotels, "У мамы лучше", 40);
//        Hotel.printAvailableApartmentByHotelName(new Hotel[0], "У мамы лучше", 4);
//        Hotel.printAvailableApartmentByHotelName(new Hotel[1], "У мамы лучше", 4);
    }

}
