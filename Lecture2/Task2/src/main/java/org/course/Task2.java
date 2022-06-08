package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};
        int nTeach = 0;
        int nStud = 0;
        int max = 0;
        int q = 0;
        nTeach = teachers.length;
        nStud = students.length;
        String [][] ds  = new String[nTeach] [nStud];
        int[] ct = new int[nTeach];
        int[] mV = new int[nStud];
        for (int i = 0; i < nTeach; i = i + 1) {
            int n = i + 1;
            System.out.println("Ментор" + " " + n + ":");
            System.out.println(teachers[i]);
            System.out.println(" ");
            System.out.println("Студенты:");
            for (int j = i; j < nStud; j = j + nTeach) {
                System.out.println(students[j] + " ");
                ct[i] = ct[i]+1;
            }
            System.out.println(" ");

        }

        for (int t = 0; t < nStud; t++) {
            mV[t] = students[t].length();
            if (mV[t] > max) {
                q = t;
            }

        }

        double av = 0;
            double s = 0;
            for (int x = 0; x < nTeach; x++) {
                s += ct[x];
            }
            av = s / nTeach;



        System.out.println("В среднем на каждого ментора приходится по" + " " + av + " " + "студентов");

        System.out.println("Во всей группе самое длинное имя у студента, которого зовут" + " " + students[q]);




    }
}
