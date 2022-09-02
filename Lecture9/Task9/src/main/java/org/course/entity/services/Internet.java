package org.course.entity.services;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Internet extends ServicesAbstract {

    int speed = 256;

    public String getName(){
        return "интернет (скорость соединения " + speed + " Кб\\с)";
    }

}
