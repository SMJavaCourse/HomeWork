package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[]{"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[]{"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};

        for (int i=0; i < teachers.length; ++i) {
            System.out.println("Ментор " + (i+1) + ":" + "\n" + teachers[i] + "\n" + "Студенты:");
            String l = teachers[i];

            for (int f=i; students.length>f; f=f+teachers.length) {
                System.out.println(students[f]);
                if (students[f].length()>students[i].length()) {
                    l = students[f];
                } else if (students[i].length()> teachers[i].length()) {
                    l = students[i];
                }
            }
            System.out.println("-----------Дольше всех в группе своё имя пишет " + l + "-----------");
            System.out.println("\n");
        }
        float value = students.length*10/ teachers.length;
        value = value/10;
        String result = String.format("%.2f", value);
        System.out.println("В среднем на каждого ментора приходится " + result + " студента");
    }
}
