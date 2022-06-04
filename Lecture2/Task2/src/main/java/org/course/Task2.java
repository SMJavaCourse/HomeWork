package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};

        String groups [][] = new String[teachers.length][];
        for (int i = 0; i< teachers.length; ++i) {

            int l = ((students.length - i - 1) / teachers.length) + 2;

            groups[i] = new String[l];
            groups[i][0] = teachers[i];

        }
        String max = students[0];
        for (int j=0; j< students.length; ++j) {
            int gi = j % teachers.length;
            groups[gi][1 + (j - gi) / teachers.length] = students[j];
            if (max.length()<students[j].length()){
            max = students[j];
            }
        }

        for (int i = 0; i < groups.length; ++i) {
            System.out.println("Ментор " + (i+1) + ":");
            System.out.println(groups[i][0]);
            System.out.println("Студенты:");

            for (int j = 0; j < groups[i].length - 1; ++j) {

                System.out.print(groups[i][j + 1] + ", ");
            }
        System.out.println();
        }

        float d = (float) (students.length) / (float)(teachers.length);

        System.out.printf("В среднем на каждого ментора приходится по: %.2f студента", d);
        System.out.println();
        System.out.println("Во всей группе самое длинное имя у " + max);
    }

}
