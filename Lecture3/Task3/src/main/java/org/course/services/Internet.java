package org.course.services;

public class Internet extends Services {

    //TODO иметь возможность указать скорость соединения, умолчательная 256 Кб\с
    int speed = 256;

    public Internet(Object o) {
        super();
    }

    public String getName(){
        return "интернет (скорость соединения " + speed + " Кб\\с)";
    }

}
