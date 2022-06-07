package org.course;

public class Task2 {

    public static void main(String[] students) {
        String[] teachers = new String[]{"Белецкий Денис", "Брук Марк", "Ёлкин Александр", "Лозицкий Дмитрий", "Южаков Станислав"};
        String longName = "";

        float count = (float) students.length / (float) teachers.length;

        System.out.println();

        for (int i = 0; i < teachers.length; i++) {
            System.out.print("Ментор " + (i + 1) + ":" + "\n" + teachers[i] + "\n" + "Студенты:" + "" + "\n");
            int nextStudent = i;
            try {
                System.out.print(students[i]);
            do {
                nextStudent += teachers.length;
                if (longName.length() < students[i].length()) {
                    longName = students[i];
                }
                else if (longName.length() < students[nextStudent].length()) {
                    longName = students[nextStudent];
                }
                    System.out.print(", " + students[nextStudent]);
                } while (nextStudent + teachers.length < students.length);
            } catch (ArrayIndexOutOfBoundsException a){
                //хз, что сюда записать, ловить ловить исключение не планируется
            }
            System.out.println();
        }
        System.out.println("\n" + "В среднем на каждого ментора приходится по " + String.format("%.2f",count) +
                 " студента" + "\n" + "Во всей группе самое длинное имя у '" + longName + "'");
    }
}