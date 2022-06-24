package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[]{"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[]{"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};

        String theLongestName = teachers[0];
        for (int i = 0; i < teachers.length; ++i) {
            System.out.println("Ментор " + (i + 1) + ":" + "\n" + teachers[i] + "\n" + "Студенты:");
            String longestName = teachers[i];

            if (teachers[i].length() > theLongestName.length()) {
                theLongestName = teachers[i];
            }

            for (int g = i; g < students.length; g = g + teachers.length) {
                System.out.println(students[g]);
                if (students[g].length() > longestName.length()) {
                    longestName = students[g];
                }
                if (students[g].length() > theLongestName.length()) {
                    theLongestName = students[g];
                }
            }
            System.out.println("-----------Дольше всех в группе своё имя пишет " + longestName + "-----------");
            System.out.println("\n");
        }
        float value = (float) students.length / teachers.length;
        String result = String.format("%.2f", value);
        System.out.println("В среднем на каждого ментора приходится " + result + " студента");
        String allLongName = teachers[0];
//        for (int i = 1; teachers.length > i; ++i) {
//            if (teachers[i].length() >= allLongName.length()) {
//                allLongName = teachers[i];
//            }
//        }
//        for (int i = 0; students.length > i; ++i) {
//            if (students[i].length() >= allLongName.length()) {
//                allLongName = students[i];
//            }
//        }
        System.out.println("А совсем-совсем дольше всех пишет имя " + theLongestName);
    }
}
