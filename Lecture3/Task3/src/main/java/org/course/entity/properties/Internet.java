package org.course.entity.properties;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Internet extends Services {

    int speed = 256;

    public String getName(){
        return "интернет (скорость соединения " + speed + " Кб\\с)";
    }

}
