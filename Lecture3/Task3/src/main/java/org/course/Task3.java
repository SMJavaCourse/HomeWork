package org.course;

public class Task3 {
    public static void main(String[] args) {
        Apartment room1 = new Apartment(1,1000,2);
        room1.num = 1;
        room1.apartment = 1;
        room1.price = 1000.0F;
        room1.time = "12:00";
        room1.isClean = false;
        room1.isInternet = false;
        room1.isСonditioner = false;
        room1.isBalcony = true;

        Apartment room2 = new Apartment(2,3000,4);
        room2.num = 2;
        room2.apartment = 2;
        room2.price = 3000.0F;
        room2.time = "12:00";
        room2.isClean = true;
        room2.isInternet = true;
        room2.isСonditioner = true;
        room2.isBalcony = true;

        Apartment room3 = new Apartment(2,3000,4);
        room3.num = 3;
        room3.apartment = 2;
        room3.price = 3000.0F;
        room3.time = "12:00";
        room3.isClean = true;
        room3.isInternet = true;
        room3.isСonditioner = true;
        room3.isBalcony = true;

        Apartment room4 = new Apartment(3,2500,6);
        room4.num = 4;
        room4.apartment = 3;
        room4.price = 2500.0F;
        room4.time = "12:00";
        room4.isClean = false;
        room4.isInternet = false;
        room4.isСonditioner = false;
        room4.isBalcony = false;

        Apartment room5 = new Apartment(4,3500, 6);
        room5.num = 5;
        room5.apartment = 4;
        room5.price = 3500.0F;
        room5.time = "12:00";
        room5.isClean = false;
        room5.isInternet = true;
        room5.isСonditioner = false;
        room5.isBalcony = true;

        Apartment room6 = new Apartment(1,1000, 2);
        room6.num = 6;
        room6.apartment = 1;
        room6.price = 1000.0F;
        room6.time = "9:00";
        room6.isClean = false;
        room6.isInternet = false;
        room6.isСonditioner = false;
        room6.isBalcony = true;

        Apartment room7 = new Apartment(2,1000, 4);
        room7.num = 7;
        room7.apartment = 2;
        room7.price = 1000.0F;
        room7.time = "09:00";
        room7.isClean = true;
        room7.isInternet = false;
        room7.isСonditioner = false;
        room7.isBalcony = true;

        Apartment room8 = new Apartment(3,4000, 4);
        room8.num = 8;
        room8.time = "09:00";
        room8.isClean = true;
        room8.isInternet = false;
        room8.isСonditioner = false;
        room8.isBalcony = false;

        Hotel hotel1 = new Hotel("У мамы лучше", new Apartment[]{room1, room2, room3, room4, room5});
        hotel1.print();
        System.out.println();
        Hotel hotel2 = new Hotel("Шашлычок", new Apartment[]{room6, room7, room8});
        hotel2.print();
        System.out.println();
    }
}