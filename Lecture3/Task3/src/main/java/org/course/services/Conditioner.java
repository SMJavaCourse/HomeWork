package org.course.services;

public class Conditioner extends Services {

    private static Conditioner instance;

    public static Conditioner getInstance(){
        if (instance == null) {
            instance = new Conditioner();
        }
        return instance;
    }

    public String getName(){
        return "кондиционер";
    }
}
