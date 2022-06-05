package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};
        appointer(teachers, students);
        averageStudents(teachers, students);
        longestName(students);
    }

    private static void appointer(String[] teachers, String[] students) {
        for (int i = 0, mentorNumber = 1; i < teachers.length; i++, mentorNumber++) {
            System.out.println("Ментор " + mentorNumber + ". \n" + teachers[i]);
            System.out.println("Студенты:");
            for (int j = i; j < students.length; j = j + teachers.length) {
                System.out.print(students[j] + ", ");
            }
            System.out.println();
        }
    }

    private static void averageStudents(String[] teachers, String[] students) {
        float averageStudents = (float) students.length / (float) teachers.length;
        String roundedResult = String.format("%.2f", averageStudents);
        System.out.println("\nВ среднем на каждого ментора приходится по " + roundedResult + " студента.");
    }

    private static void longestName(String[] students) {
        int maxLength = 0;
        String longestName = "";
        for (String student : students) {
            if (student.length() > maxLength) {
                maxLength = student.length();
                longestName = student;
            }
        }
        System.out.println("\nВо всей группе самое длинное имя у '" + longestName + "'");
    }
}
