package org.course;

public class Task2 {

    public Task2() {
    }

    public static void main(String[] students) {
        String maxName = "";
        double meanValue;
        String result;
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
//        String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
//                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};
        for (int i = 0; i < teachers.length; i++) {
            System.out.println("Ментор "+ (i+1) +":");
            System.out.println(teachers[i]);
            System.out.println("Студенты:");
            for (int j = i; j < students.length; j += teachers.length) {
                if (j != i) {
                    System.out.print(", ");
                }
                System.out.print(students[j]);
                if (students[j].length() > maxName.length()) {
                    maxName = students[j];
                }
            }
            System.out.println(System.lineSeparator());
        }
        meanValue = (double)students.length / (double)teachers.length;
        result = String.format("%.2f", meanValue);
        System.out.println("В среднем на каждого ментора приходится по " + result + " студента " + System.lineSeparator() +
                "Во всей группе самое длинное имя у '" + maxName + "'");
    }
}
