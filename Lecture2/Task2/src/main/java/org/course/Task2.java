package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[]{"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[]{"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};

        //int tt = 0;
        String teacherStudents = "";
        String maxStudentLen = "";

        for (int i = 0; i < teachers.length; i++) {
            System.out.println("Ментор " + (i +1) + ":");
            System.out.println(teachers[i]);
            System.out.println("Студенты:");
            int tt = i;
            for (int j = 0; j < students.length; j++) {
                if (j == tt) {
                    if (tt == i) {
                        teacherStudents = students[tt];
                    }
                    else {
                        teacherStudents = teacherStudents + ", " + students[tt];
                    }
                    tt = tt + teachers.length;

                }
                if (students[j].length() > maxStudentLen.length()) {
                    maxStudentLen = students[j];
                }
            }
            System.out.println(teacherStudents);
        }
        float tl = teachers.length;
        float sl = students.length;
        float avgSt = sl/tl;
        System.out.println("В среднем на каждого ментора приходится по " + String.format("%.2f",avgSt) + " студента");
        System.out.println("Во всей группе самое длинное имя у '" + maxStudentLen + "'");


    }
}


