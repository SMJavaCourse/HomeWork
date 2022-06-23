package org.course;

public class Room {
    public int num;
    public int room;
    public float price;
    public String time;

    public int capacity;

    public boolean isBal;
    public boolean isClean;
    public boolean isInternet;
    public boolean isCondei;
    public boolean isShashl;

    public Facility[] facilities = new Facility[0];

    public void print() {
        String a = "";
        switch (room){
            case 1:
                a = "Однокомнатный номер";
                break;
            case 2:
                a = "Двухкомнатый номер";
                break;
            case 3:
                a = "Трехкомнатный номер";
                break;
            case 4:
                a = "Четырехкомнатный номер";
        }

        System.out.print(a);
        System.out.println(" (комната номер: " + num + ")");
        System.out.println("    Цена: " + price + " р/сутки");
        System.out.println("    Вместимость до " + capacity + " человек");
        System.out.println("    Время заселение/выселения: " + time);
        String s = "Дополнительный услуги: ";
        if (isBal){
            s = s+"балкон, ";

        }
        if (isClean){
            s = s+"уборка номера, ";

        }
        if (isClean){
            s = s+"уборка номера, ";

        }
        if (isInternet){
            s = s+"интернет, ";


        }
        if (isCondei){
            s = s+"кондиционер, ";

        }
        if (isShashl){
            s = s+"шашлычок в номер, ";

        }
        System.out.println(s);
        System.out.println();



    }

    ;


}
