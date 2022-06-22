package org.course;

public class Room {

  public int roomAmount;
  public String services;
  public double price;
  public int roomNumber;
  public int maxPersons;
  public String checkInTime;
  public int count;

  public Room (int roomAmount, String services, double price, int roomNumber, int maxPersons, String checkInTime, int count){
    this.roomAmount = roomAmount;
    this.services = services;
    this.price = price;
    this.roomNumber = roomNumber;
    this.maxPersons = maxPersons;
    this.checkInTime = checkInTime;
    this.count = count;
  }

  public Room(){
  }

  public String convertAmount(int roomAmount){
    String amount = switch (roomAmount) {
      case 1 -> "Однокомнатый номер";
      case 2 -> "Двухкомнатый номер";
      case 3 -> "Трехкомнатный номер";
      default -> "Президентский номер";
    };
    return amount;
  }


}
