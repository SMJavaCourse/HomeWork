package org.course;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"}; // 5
        String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"}; // 11

        System.out.println("\nСамое длинное имя у студента " + maxNameLength(students));
        System.out.println("\nВ среднем на учителя приходится " + studentsAverage(students, teachers));
        System.out.print("\n*** Список студентов для каждого учителя ***");
        getStudentsForEachTeacher(students, teachers);
    }
    public static void getStudentsForEachTeacher(String[] students, String[] teachers) {
        int studentIndex = 0;
        int arrSize = ((float)students.length/ (float) teachers.length)-(float)(students.length/ teachers.length) == 0 ?
                students.length/ teachers.length + 1 : students.length/ teachers.length + 2;
        String[] arrayTeacherAndStudents =
                new String[arrSize];
        int index = 1;
        for (int t = 0; t < teachers.length; t++) {
            arrayTeacherAndStudents[0] = teachers[t];
            for (int s = studentIndex; s < students.length; s++) {
                if (index == arrSize) {continue;}
                if (index == arrSize-1 && t > 0) {continue;}
                arrayTeacherAndStudents[index] = students[s];
                s+=3;
                index++;
                studentIndex++;
            }
            System.out.println("\nСписок студентов для учителя " + arrayTeacherAndStudents[0] + ": ");
            Arrays.stream(arrayTeacherAndStudents).toList().subList(1, arrayTeacherAndStudents.length).stream()
                    .filter(e -> e!=null)
                    .forEach(e -> System.out.println(e));
            studentIndex = t+1;
            index = 1;
            arrayTeacherAndStudents = new String[arrSize];
        }
    }

    public static String maxNameLength(String[] students) {
        String maxName = students[0];
        for (int i = 0; i < students.length; i++) {
            if (Arrays.stream(students[i].split("\\s")).toList().get(1).length() >
                    Arrays.stream(maxName.split("\\s")).toList().get(1).length()) { maxName = students[i]; }
        }
        return maxName;
    }

    public static double studentsAverage(String[] students, String[] teachers) {
        return (double) students.length / teachers.length;
    }
}
