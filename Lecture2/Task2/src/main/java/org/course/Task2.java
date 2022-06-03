package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};

        String longName = "";
        float count = (float) students.length / (float) teachers.length;

        System.out.println();

        for (int i = 0; i < teachers.length; i++) {
            System.out.println("Ментор "+(i+1)+":" + "\n" + teachers[i] + "\n" + "Студенты:");
            for (int j = i; j < students.length; j+= teachers.length) {
                System.out.print(students[j]);
                if (j + teachers.length <= students.length-1) {
                    System.out.print(", ");
                }
                else {
                    System.out.println();
                }
                if (longName.length() < students[j].length()) {
                    longName = students[j];
                }
            }
        }
        System.out.println("\n" + "В среднем на каждого ментора приходится по " + count + " студента" +
                "\n" + "Во всей группе самое длинное имя у '" + longName + "'");
    }
}
