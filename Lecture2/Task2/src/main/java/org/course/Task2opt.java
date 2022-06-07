package org.course;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Task2opt {

    public static void main(String[] students) {
        String[] teachers = new String[]{"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        ArrayList<StringJoiner> groups = new ArrayList<>();
        for (String ignored : teachers) {
            groups.add(new StringJoiner(", "));
        }
        int teacherCount = teachers.length;
        String longName = "";

        for (int i = 0; i < students.length; i++) {
            int groupNumber = i % teacherCount;
            groups.get(groupNumber).add(students[i]);
            if (longName.length() < students[i].length()) {
                longName = students[i];
            }
        }

        float count = (float) students.length / (float) teachers.length;

        for (int i = 0; i < teachers.length; i++) {
            System.out.println("Ментор " + (i + 1) + ": " + teachers[i] + "\n" + "Студенты: " + groups.get(i).toString());
        }

        System.out.println("\n" + "В среднем на каждого ментора приходится по " + String.format("%.2f", count) +
                " студента" + "\n" + "Во всей группе самое длинное имя у '" + longName + "'");
    }
}