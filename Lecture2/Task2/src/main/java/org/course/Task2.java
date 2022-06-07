package org.course;

public class Task2 {

    public static void main(String[] students) {
        String[] teachers = new String[]{"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};

        String longName = "";
        float count = (float) students.length / (float) teachers.length;
        System.out.println();

        for (int i = 0; i < teachers.length; i++) {
            System.out.print("Ментор " + (i + 1) + ":" + "\n" + teachers[i] + "\n" + "Студенты:" + "" + "\n" + students[i]);
            if (longName.length() < students[i].length()) {
                longName = students[i];
            }
            int nextStudent = i;
            do {
                System.out.print(", ");
                nextStudent += teachers.length;
                System.out.print(students[nextStudent]);
                if (longName.length() < students[nextStudent].length()) {
                    longName = students[nextStudent];
                }
            } while (nextStudent + teachers.length < students.length);
            System.out.println("");
        }

        System.out.println("\n" + "В среднем на каждого ментора приходится по " + String.format("%.2f",count) +
                 " студента" + "\n" + "Во всей группе самое длинное имя у '" + longName + "'");
    }
}