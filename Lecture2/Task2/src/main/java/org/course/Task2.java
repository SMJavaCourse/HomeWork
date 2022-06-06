package org.course;

import static java.lang.System.*;

public class Task2 {

    public static void main(String[] args) {
        String stud_list = "";
        String delimiter = ", ";
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};
        String[][] complex = new String[teachers.length][];
        for (int i = 0; i < teachers.length; i++) {
            out.println("Mentor 1: " + teachers[i]);
            out.print("Students: ");
            for (int j = i; j < students.length; j=j+teachers.length) {
                if (j==i){
                    stud_list = students[j];
                }
                else {
                    stud_list = String.join(delimiter, stud_list, students[j]);
                }
            }
            out.println(stud_list);
            stud_list = "";
        }
        out.println("В среднем на каждого ментора приходится по "+ (double)students.length/teachers.length +" студента");
        }
}
