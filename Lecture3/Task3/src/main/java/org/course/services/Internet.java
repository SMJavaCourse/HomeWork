package org.course.services;

public class Internet extends Services {

    int speed = 256;

    public Internet(int speed) {
        this.speed = speed;
    }

    public Internet() {
    }

    public String getName(){
        return "интернет (скорость соединения " + speed + " Кб\\с)";
    }

}
