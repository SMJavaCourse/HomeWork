package org.course.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.course.dao.ApartmentRepository;

@Data
@RequiredArgsConstructor
public class Apartment {
    private final String id;
    private final String hotelId;
    private final int rooms;
    private final int numberOfRoom;
    private final int price;
    private final int capacity;
    private String name;

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
