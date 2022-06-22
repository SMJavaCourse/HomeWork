package org.course;

import java.util.Arrays;

public class Hotel {
  private String name;
  private Apartment[] apartments;

  private Room[] rooms;

/*    public Hotel(String name, Apartment[] apartments) {
        this.name = name;
        this.apartments = apartments;
    }*/

  public Hotel(String name, Room[] rooms) {
    this.name = name;
    this.rooms = rooms;
  }

  public void printInfo(){
    String str;
    int cnt = 0;
    System.out.println("Отель \"" + name + "\"");
    System.out.println("Номера:");
    for (Room room : rooms) {
      str = room.convertAmount(room.roomAmount);
      System.out.println("\t" + str + " (комната номер " + room.roomNumber + ")" +
          ":\n\r\t\t - Количество номеров: " + room.count +
          "\n\r\t\t - Цена: " + room.price +" р/сутки" +
          "\n\r\t\t - Время заселения: " + room.checkInTime +
          "\n\r\t\t - Дополнительные услуги: " + room.services +
          "\n\r\t\t - Вместимость до "+ room.maxPersons +" человек" );
      cnt += room.count;
    }
    System.out.println("Общее количество номеров в отеле "+ cnt + "\n\r");

  }
}
