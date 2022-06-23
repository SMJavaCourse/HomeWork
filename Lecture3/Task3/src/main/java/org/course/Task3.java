package org.course;

import org.course.hotels.Grill;
import org.course.hotels.Mother;

public class Task3 {
    public static void main(String[] args) {
        Mother mother = new Mother("09:00");

        Grill grill = new Grill("12:00");

        mother.soutName();
        mother.soutTime();
        mother.countRooms();
        mother.soutRooms();
        System.out.println("\n");



        grill.soutName();
        grill.soutTime();
        grill.countRooms();
        grill.soutRooms();
    }

}
