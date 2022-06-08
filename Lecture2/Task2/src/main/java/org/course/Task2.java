package org.course;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[]{"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[]{"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};
        double teachersSize = teachers.length;
        double overline = students.length / teachersSize;
        System.out.println("Среднее количество студентов: " + overline);
        String maxLength = "";
        for (int j = 0; j < students.length; j++) {
            if (students[j].length() > maxLength.length())
                maxLength = students[j];
        }
        for (int j = 0; j < teachers.length; j++) {
            if (students[j].length() > maxLength.length())
                maxLength = teachers[j];
        }
        System.out.println("Самое длинное значение:" + maxLength);
        for (int i = 0; i < teachers.length; i++) {
            System.out.println("Группа № " + i);
            System.out.println("Ментор: " + teachers[i]);
            int mod = students.length % teachers.length;
            int arraySize;
            if (i <= (mod - 1)) {
                arraySize = (students.length / teachers.length + 1);
            } else {
                arraySize = (students.length / teachers.length);
            }
            String[] mentorStudents = new String[arraySize];
            for (int count = i, studentsCount = 0; count < students.length; count = (count + teachers.length), studentsCount++) {
                String studentsName = students[count];
                mentorStudents[studentsCount] = studentsName;
            }
            String mentorStudentsArrayString = Arrays.toString(mentorStudents);
            System.out.println("Студенты: " + mentorStudentsArrayString);
        }

    }
}



