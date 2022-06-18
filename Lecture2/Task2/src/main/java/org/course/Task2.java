package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[] {"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[] {"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};
        String max = students[0];
        for (int j=0; j< teachers.length; j++){
            System.out.println("Ментор " +  (j+1) + ": ");
            System.out.println(teachers[j]);
            System.out.println("Студенты: ");
            for (int i = j; i< students.length; i=i + teachers.length){

                if (max.length()<students[i].length()) {
                    max=students[i];
                }
                System.out.print(students[i] +", ");

            }
            System.out.println();

        }

        float a = students.length/ (float)  teachers.length;
        System.out.println();
        System.out.println("В среднем на каждого ментора приходится по: " + a + " студента");
        System.out.println("Во всей группе самое длинное имя у: " + max);





    }
}



