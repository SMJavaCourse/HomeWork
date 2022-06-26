package org.course;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        Apartment[] apartments = new Apartment[2];
        apartments[0] = new Apartment(1,123);
        apartments[1] = new Apartment(1,312);
        Hotel hotel1 = new Hotel("Первый нахъ", apartments);
        System.out.println(hotel1);


        //проверка, что я не совсем кукухой отлетел и оно должно выводить хоть что то
        String[] i = new String[2];
        i[0]="ёпт";
        i[1]="2";
        System.out.println(Arrays.toString(i));
    }

}
