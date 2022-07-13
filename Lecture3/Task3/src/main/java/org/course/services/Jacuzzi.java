package org.course.services;

public class Jacuzzi extends Services {

    private static Jacuzzi instance;

    public static Jacuzzi getInstance(){
        if (instance == null) {
            instance = new Jacuzzi();
        }
        return instance;
    }

    public String getName(){
        return "джакузи";
    }
}
