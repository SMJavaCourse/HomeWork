package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[]{"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[]{"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};

        for (int i = 0; i < teachers.length; i++) {
            System.out.println("Ментор " + (i + 1) + ":" + "\n" + teachers[i] + "\n" + "Студенты:");
            for (int j = i; j < students.length; j += teachers.length) {
                System.out.print(students[j]);
                if (j + teachers.length <= students.length - 1) {
                    System.out.println(", ");
                } else {
                    System.out.println("\n");
                }
            }
        }

        float a = students.length / (float) teachers.length;
        System.out.println();
        System.out.println("В среднем на каждого ментора приходится по: " + a + " студента");
        String longestName = teachers[0];
        for (int i = 1; teachers.length > i; ++i) {
            if (teachers[i].length() >= longestName.length()) {
                longestName = teachers[i];
            }
        }
        for (int i = 0; students.length > i; ++i) {
            if (students[i].length() >= longestName.length()) {
                longestName = students[i];
            }
        }
        System.out.println("Во всей группе самое длинное имя у: '" + longestName + "'");
    }
}
