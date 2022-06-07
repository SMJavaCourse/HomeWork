package org.course;

import java.util.Scanner;

import static java.lang.System.out;

public class Task2Dialog {

    public static void main(String[] args) {
        String stud_list = "";
        String delimiter = ", ";
        int max = 0;
        String max_name = "";
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        /*String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};*/
        String[] students = getStudents();
        for (int i = 0; i < teachers.length; i++) {
            out.println("Mentor 1: " + teachers[i]);
            out.print("Students: ");
            for (int j = i; j < students.length; j=j+teachers.length) {
                stud_list = (j==i) ?  students[j] : String.join(delimiter, stud_list, students[j]);
                if (max < students[j].length()){
                    max=students[j].length();
                    max_name = students[j];
                }
            }
            out.println(stud_list);
            stud_list = "";
        }
        out.println("В среднем на каждого ментора приходится по "+ (double)students.length/teachers.length +" студента");
        out.println("Во всей группе самое длинное имя у "+ max_name +". Длина имени равна "+ max);
        }
    public static String[] getStudents(){
        Scanner in = new Scanner(System.in);
        out.println("Введите кол-во обучающихся : ");
        int size = in.nextInt();
        String[] stud = new String[size];
        in.nextLine();
        for (int i = 0; i < stud.length; ++i) {
            out.println("Введите имя студента номер " + (i + 1) +":");
            stud[i] = in.nextLine();
        }
        return stud;
    }
}
