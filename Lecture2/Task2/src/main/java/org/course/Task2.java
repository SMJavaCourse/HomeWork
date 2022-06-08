package org.course;

import java.util.*;

import static java.lang.System.*;
/*String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина",
                "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};*/
public class Task2 {

    public static void main(String[] args) {
        String stud_list = "", max_name = "";
        int max = 0;
        String[] students = new String[args.length];
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        System.arraycopy(args, 0, students, 0, args.length);
        for (int i = 0; i < teachers.length; i++) {
            out.println("Ментор 1: " + teachers[i]);
            out.print("Студенты: ");
            for (int j = i; j < students.length; j = j+teachers.length) {
                String student = students[j];
                stud_list = (j==i) ?  student : String.join(", ", stud_list, student);
                if (max < student.length()){
                    max = student.length();
                    max_name = student;
                }
            }
            out.println(stud_list);
            stud_list = "";
        }
        out.println("В среднем на каждого ментора приходится по "+ (double)students.length/teachers.length +" студента");
        out.println("Во всей группе самое длинное имя у "+ max_name +". Длина имени равна "+ max);
        }
}
