package org.course.entity;

import lombok.Data;
import org.course.repository.ApartmentRepository;

@Data
public class Apartment {
    private String id;
    private String hotelId;
    private int rooms;
    private int numberOfRoom;
    private int price;
    private int capacity;
    private String name;

    public Apartment(String id, String hotelId, int rooms, int numberOfRoom, int price, int capacity) {
        this.id = id;
        this.hotelId = hotelId;
        this.rooms = rooms;
        this.numberOfRoom = numberOfRoom;
        this.price = price;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        if (rooms == 1) {
            name = "Однокомнатный номер";
        } else if (rooms == 2) {
            name = "Двухкомнатный номер";
        } else if (rooms == 3) {
            name = "Трёхкомнатный номер";
        }
        StringBuilder apartmentToString = new StringBuilder()
                .append("\t\u2219 ")
                .append(name)
                .append(" (комната номер ")
                .append(numberOfRoom)
                .append("):\n\t\t\u25e6 Цена: ")
                .append(price)
                .append("\n\t\t\u25e6 Дополнительные услуги: ")
                .append(ApartmentRepository.soutServices(ApartmentRepository.allServicesInApartment(id)));
        return apartmentToString.toString();
    }
}
