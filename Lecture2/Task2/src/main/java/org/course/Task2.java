package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[]{"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[]{"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};
        double teachersSize = teachers.length;
        double overline = students.length / teachersSize;
        System.out.println("Среднее количество студентов: " + overline);
        String maxLength = "";
        for (int i = 0; i < teachers.length; i++) {
            System.out.println("\n Группа № " + i + ":");
            System.out.println("Ментор: " + teachers[i]);
            for (int count = i, studentsCount = 0; count < students.length; count = (count + teachers.length), studentsCount++) {
                maxLength = teachers[i];
                if (students[count].length() > maxLength.length()) {
                    maxLength = students[count];
                }
                if (count != i) {
                    System.out.print(", ");
                }
                System.out.print(students[count]);


            }
            System.out.println("\nСамое длинное значение в группе: " + maxLength);

        }

    }
}



