package org.course;

public class Hotel {
    private String name;
    private Room[] rooms;


    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public void print(){

        System.out.println("Отель: " + name);
        System.out.println("Количество номеров: " + rooms.length);
        System.out.println("Номера:");
        for (int i =0; i< rooms.length; i++){
            if (rooms[i].getCapacity() > 4){
                System.out.println("Это огромная комната!");
            }
            rooms[i].print();

        }
    };
}
