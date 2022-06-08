package org.course;

public class Task2 {

    public static void main(String[] args) {
        String[] teachers = new String[]{"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String[] students = new String[]{"Яблоков Дмитрий", "Надолинский Артем", "Салатенков Илья", "Мамутов Сергей",
                "Моисеев Артём", "Гагаева Мария", "Малышева Карина", "Федоренко Яна", "Положенцева Анна", "Шипулина Юлия", "Никифоров Максим"};
        double teachersSize = teachers.length;
        double overline = students.length / teachersSize;
        System.out.printf("Среднее количество студентов: %.2f %n", overline);
        String maxLength = "";
        String maxStudentLenght= "";
        for (int i = 0; i < teachers.length; i++) {
            System.out.println("\nГруппа № " + i + ":");
            System.out.println("Ментор: " + teachers[i]);
            for (int count = i; count < students.length; count = (count + teachers.length)) {
                maxLength = teachers[i];
                if (students[count].length()>maxStudentLenght.length()){
                    maxStudentLenght= students[count];
                }
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
        System.out.println("\nВаще самое длинное: " + maxStudentLenght +" =)");
    }
}



