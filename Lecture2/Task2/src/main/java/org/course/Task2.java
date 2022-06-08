package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};
        int numberOfTeachers = teachers.length;
        int numberOfStudents = students.length;
        int maximumLengthOfName = 0;
        int maximumLengthOfNameIndex = 0;

        int[] lengthOfName = new int[numberOfStudents];
        for (int i = 0; i < numberOfTeachers; i = i + 1) {
            int n = i + 1;
            System.out.println("Ментор" + " " + n + ":");
            System.out.println(teachers[i]);
            System.out.println(" ");
            System.out.println("Студенты:");
            for (int j = i; j < numberOfStudents; j = j + numberOfTeachers) {
                System.out.println(students[j] + " ");
                lengthOfName[j] = students[j].length();
            }
            System.out.println(" ");

        }

        for (int i = 0; i < numberOfStudents; i++) {
            if (lengthOfName[i] > maximumLengthOfName) {
                maximumLengthOfName = lengthOfName[i];
                maximumLengthOfNameIndex = i;
            }

        }

        float numOfStud = numberOfStudents;
        float numOfTea = numberOfTeachers;

        float averageQuantityOfStudents = numOfStud / numOfTea;


        System.out.println("В среднем на каждого ментора приходится по" + " " + averageQuantityOfStudents + " " + "студентов");

        System.out.println("Во всей группе самое длинное имя у студента, которого зовут" + " " + students[maximumLengthOfNameIndex]);




    }
}
