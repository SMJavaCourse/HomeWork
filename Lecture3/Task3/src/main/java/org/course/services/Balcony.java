package org.course.services;

public class Balcony extends Services {

    private static Balcony instance;

    public static Balcony getInstance(){
        if (instance == null) {
            instance = new Balcony();
        }
        return instance;
    }

    public String getName(){
        return "балкон";
    }
}
