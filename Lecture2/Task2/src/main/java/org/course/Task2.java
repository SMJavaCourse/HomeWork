package org.course;

public class Task2 {

    public Task2() {
    }

    public static void main(String[] args) {
        int maxChar = 0;
        String maxName = "";
        double meanValue;
        String result;
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};
        for (int i = 0; i < teachers.length; i++) {
            int numberOfTeacher = i;
            System.out.println("Ментор "+ ++numberOfTeacher +":");
            System.out.println(teachers[i]);
            System.out.println("Студенты:");
            boolean comma = false;
            for (int j = i; j < students.length; j = j + 4) {
                if (comma) {
                    System.out.print(", ");
                }
                System.out.print(students[j]);
                comma = true;
            }
            System.out.println(".");
        }
        meanValue = (double)students.length / (double)teachers.length;
        result = String.format("%.2f", meanValue);
        for (String student : students) {
            if (student.length() > maxChar) {
                maxChar = student.length();
                maxName = student;
            }
        }
        System.out.println("В среднем на каждого ментора приходится по " + result + " студента Во всей группе самое длинное имя у '" + maxName + "'");
    }
}
