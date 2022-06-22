package org.course;

public class HotelBooking {
    public static void main(String[] args) {
        Room room1 = new Room(1,"балкон, уборка номера, интернет, кондиционер",1500.00, 201, 2, "12:00", 3);

        Room room2 = new Room(3,"уборка номера, шашлычок в номер, кондиционер",2500.00, 110, 4, "09:00",2);

        Room room3 = new Room(5,"балкон, уборка номера, бассейн, питание, шашлычок в номер, кондиционер",3300.00, 10, 3, "14:00",1);

        Room room4 = new Room(2,"уборка номера, бассейн, питание, шашлычок в номер, кондиционер",2300.00, 310, 3, "12:00",10);

        Room room5 = new Room(1,"балкон, сауна, уборка номера, бассейн, питание",9000.00, 1120, 5, "09:00",20);

        Hotel hotel1 = new Hotel("У мамы лучше", new Room[] {room1,room2, room3});
        hotel1.printInfo();

        Hotel hotel2 = new Hotel("Шашлычок", new Room[] {room4, room5, room2});
        hotel2.printInfo();
    }
}
