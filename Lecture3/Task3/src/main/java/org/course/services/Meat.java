package org.course.services;

public class Meat extends Services {

    private static Meat instance;

    public static Meat getInstance(){
        if (instance == null) {
            instance = new Meat();
        }
        return instance;
    }

    public String getName(){
        return "шашлык";
    }
}
