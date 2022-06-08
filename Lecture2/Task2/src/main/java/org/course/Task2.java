package org.course;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"}; // 5
        String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"}; // 11

        System.out.println("Список студентов для " + teachers[1] + ": " + Arrays.stream(getStudentsByTeacherName(students, teachers, teachers[1])).toList());
        System.out.println("Самое длинное имя у студента " + maxNameLength(students));
        System.out.println("В среднем на учителя приходится " + studentsPerTeacher(students, teachers));
    }

    public static String[] getStudentsByTeacherName(String[] students, String[] teachers, String teacherName) {
        int index = Arrays.asList(teachers).indexOf(teacherName);
        int maxNumOfStudents = (int) Math.ceil((float) students.length / (float) teachers.length);
        String[] subStudents = new String[maxNumOfStudents];
        int j = 0;
        for (int i = index; i < students.length; i+=3) {
            if (j == maxNumOfStudents) { break;}
            subStudents[j] = students[i];
            j++;
        }
        return subStudents;
    }

    public static String maxNameLength(String[] students) {
        String maxName = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].length() > maxName.length()) { maxName = students[i]; }
        }
        return maxName;
    }

    public static BigDecimal studentsPerTeacher(String[] students, String[] teachers) {
        return new BigDecimal((float) students.length / teachers.length).round(new MathContext(3, RoundingMode.HALF_UP));
    }
}
