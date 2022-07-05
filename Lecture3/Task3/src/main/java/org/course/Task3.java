package org.course;

public class Task3 {
    public static void main(String[] args) {
        Room room1 = new Room(1,1000,2);
        room1.num = 1;
        room1.room = 1;
        room1.price = 1000.0F;
        room1.time = "12:00";
        room1.isBal = true;
        room1.isClean = false;
        room1.isInternet = false;
        room1.isCondei = false;
        room1.isShashl = false;
        room1.facilities = new Facility[]{Facility.BALCONY};

        Room room2 = new Room(2,3000,4);
        room2.num = 2;
        room2.room = 2;
        room2.price = 3000.0F;
        room2.time = "12:00";
        room2.isBal = true;
        room2.isClean = true;
        room2.isInternet = true;
        room2.isCondei = true;
        room2.isShashl = false;

        Room room3 = new Room(2,3000,4);
        room3.num = 2;
        room3.room = 2;
        room3.price = 3000.0F;
        room3.time = "12:00";
        room3.isBal = true;
        room3.isClean = true;
        room3.isInternet = true;
        room3.isCondei = true;
        room3.isShashl = false;

        Room room4 = new Room(3,2500,6);
        room4.num = 4;
        room4.room = 3;
        room4.price = 2500.0F;
        room4.time = "12:00";
        room4.isBal = false;
        room4.isClean = false;
        room4.isInternet = false;
        room4.isCondei = false;
        room4.isShashl = false;

        Room room5 = new Room(4,3500, 6);
        room5.num = 4;
        room5.room = 4;
        room5.price = 3500.0F;
        room5.time = "12:00";
        room5.isBal = true;
        room5.isClean = false;
        room5.isInternet = true;
        room5.isCondei = false;
        room5.isShashl = false;

        Room room6 = new Room(1,1000, 2);
        room6.num = 10;
        room6.room = 1;
        room6.price = 1000.0F;
        room6.time = "9:00";
        room6.isBal = false;
        room6.isClean = false;
        room6.isInternet = false;
        room6.isCondei = false;
        room6.isShashl = true;

        Room room7 = new Room(2,1000, 4);
        room7.num = 20;
        room7.room = 2;
        room7.price = 1000.0F;
        room7.time = "09:00";
        room7.isBal = true;
        room7.isClean = true;
        room7.isInternet = false;
        room7.isCondei = false;
        room7.isShashl = false;

        Room room8 = new Room(3,4000, 4);
        room8.num = 30;
        room8.time = "09:00";
        room8.isBal = false;
        room8.isClean = true;
        room8.isInternet = false;
        room8.isCondei = false;
        room8.isShashl = false;

        Hotel hotel1 = new Hotel("У мамы лучше", new Room[]{room1, room2, room3, room4, room5});
        hotel1.print();
        System.out.println();
        Hotel hotel2 = new Hotel("Шашлычок", new Room[]{room6, room7, room8});
        hotel2.print();
        System.out.println();
        hotel1.print();


    }
}
