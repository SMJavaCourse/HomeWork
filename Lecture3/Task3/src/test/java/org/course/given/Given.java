package org.course.given;

import org.course.entity.Apartment;
import org.course.entity.properties.*;
import org.jeasy.random.EasyRandom;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Given {

    private int price;
    private static int rooms;
    private static int numberOfRoom;
    private static int capacity;
    private static ArrayList<Services> services;

    private static Object randomApartment(){
        Random random = new Random();
        rooms = random.nextInt(3) + 1;
        numberOfRoom = random.nextInt(100) + 1;
        capacity = (random.nextInt(2) + 1) * rooms;
        ArrayList<Services> sourceServices = new ArrayList<>();
        sourceServices.add(new Balcony());
        sourceServices.add(new Cleaning());
        sourceServices.add(new Conditioner());
        sourceServices.add(new Internet());
        sourceServices.add(new Jacuzzi());
        sourceServices.add(new Meat());

        EasyRandom easyRandom = new EasyRandom();
        easyRandom.nextObject(Services.class);
        return easyRandom;
    }

    public static void main(String[] args) {
        System.out.printf(randomApartment().toString());
    }
}
