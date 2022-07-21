package org.course;

public class Apartment {
    private String name;
    private int numberOfApart;
    private int rooms;
    private float price;
    private String time;
    private int capacity;

    public boolean isBalcony;
    public boolean isClean;
    public boolean isInternet;
    public boolean isСonditioner;
    public boolean isShashlik;

    public int getCapacity() {
        return capacity;
    }

    public Apartment(int num, int apartments, float price, String time, int people, boolean isBalcony, boolean isClean, boolean isInternet, boolean isСonditioner, boolean isShashlik) {
        this.numberOfApart = num;
        this.rooms = apartments;
        this.price = price;
        this.time = time;
        this.capacity = people;
        this.isBalcony = isBalcony;
        this.isClean = isClean;
        this.isInternet = isInternet;
        this.isСonditioner = isСonditioner;
        this.isShashlik = isShashlik;
    }

    private String getName(int rooms) {
        if (rooms == 1) {
            name = "Однокомнатный номер";
        } else if (rooms == 2) {
            name = "Двухкомнатный номер";
        } else if (rooms == 3) {
            name = "Трёхкомнатный номер";
        }
        return name;
    }

    public void print() {
        String a = "";
        switch (rooms) {
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
        System.out.println(" (комната номер: " + numberOfApart + ")");
        System.out.println("    Цена: " + price + " р/сутки");
        System.out.println("    Вместимость до " + capacity + " человек");
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

    @Override
    public String toString() {
        String text = "\t\u2219 " + getName(rooms) +
                " (комната номер " + numberOfApart + "):\n\t\t\u25e6 Цена: " + price +
                "\n\t\t\u25e6 Дополнительные услуги: " + isBalcony + isClean;
        return text;
    }
}