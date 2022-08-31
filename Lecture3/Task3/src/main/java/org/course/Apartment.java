package org.course;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Apartment {
    private int numberOfApart;
    private int rooms;
    private float price;
    private String time;
    private int capacity;

    public boolean isLuxury;
    public boolean isBalcony;
    public boolean isClean;
    public boolean isInternet;
    public boolean isConditioner;
    public boolean isShashlik;

    public Apartment(int num, int rooms, float price, String time, int people, boolean isBalcony, boolean isClean, boolean isInternet, boolean isСonditioner, boolean isShashlik) {
        this.numberOfApart = num;
        this.rooms = rooms;
        this.price = price;
        this.time = time;
        this.capacity = people;
        this.isBalcony = isBalcony;
        this.isClean = isClean;
        this.isInternet = isInternet;
        this.isConditioner = isСonditioner;
        this.isShashlik = isShashlik;
    }


    public void print() {
        String name = null;
        if (rooms == 1) {
            name = "Однокомнатный номер";
        } else if (rooms == 2) {
            name = "Двухкомнатный номер";
        } else if (rooms == 3) {
            name = "Трёхкомнатный номер";
        } else if (rooms == 4) {
            name = "Четырёхкомнатный номер";
        }
        if(isLuxury){
            name += " LUXURY";
        }


            System.out.print(name);
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
            if (isConditioner) {
                s = s + "кондиционер, ";
            }
            if (isShashlik) {
                s = s + "шашлычок в номер, ";
            }
            System.out.println(s);
        }
    }