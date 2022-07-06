package org.course;

public class Apartment {
    public int num;
    public int apartment;
    public float price;
    public String time;
    private int people;

    public boolean isBalcony;
    public boolean isClean;
    public boolean isInternet;
    public boolean isСonditioner;
    public boolean isShashlik;


    public Apartment(int apartment, float price, int people) {
        this.apartment = apartment;
        this.price = price;
        this.people = people;
    }

    public void print() {
        String a = "";
        switch (apartment) {
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
        System.out.println("    Вместимость до " + people + " человек");
        System.out.println("    Время заселения: " + time);
        String s = "    Дополнительный услуги: ";
        if (isBalcony) {
            s = s + "балкон, ";
        }
        if (isClean) {
            s = s + "уборка номера, ";

        }
        if (isInternet) {
            s = s + "интернет, ";

        }
        if (isСonditioner) {
            s = s + "кондиционер, ";

        }
        if (isShashlik) {
            s = s + "шашлычок в номер, ";

        }
        System.out.println(s);
        System.out.println();
    }
}