package org.course.services;

public class Cleaning extends Services {

    private static Cleaning instance;

    public static Cleaning getInstance(){
        if (instance == null) {
            instance = new Cleaning();
        }
        return instance;
    }

    public String getName(){
        return "уборка номера";
    }
}
