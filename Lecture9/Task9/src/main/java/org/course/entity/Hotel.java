package org.course.entity;

import lombok.Data;
import org.course.dao.ServiceRepository;
import org.course.entity.properties.Services;

import java.util.ArrayList;
import java.util.HashMap;

import static org.course.dao.ApartmentRepository.allApartmentsInHotel;

@Data
public class Hotel {
    private String name;
    private String id;
    private String startTime;

    public Hotel(String id, String name, String startTime) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
    }

    @Override
    public String toString() throws NullPointerException {
        StringBuilder hotelToString = new StringBuilder()
                .append("Отель \"")
                .append(name)
                .append("\nВремя заселение/выселения: ")
                .append(startTime);
        return hotelToString.toString();
    }

    public String printServices(String hotelId) {
        HashMap<String, ArrayList<Apartment>> servicesMap = new HashMap<>();
        var allApartments = allApartmentsInHotel(hotelId);
        if (allApartments.size() == 0) {
            return "У отеля нет доступных номеров";
        }
        for (Apartment apartment : allApartments) {
            var allServicesInApartments = ServiceRepository.allServicesInApartment(apartment.getId());
            for(Services service : allServicesInApartments){
                ArrayList<Apartment> apartmentList = servicesMap.get(service.getName());
                if (apartmentList == null) {
                    apartmentList = new ArrayList<>();
                    servicesMap.put(service.getName(), apartmentList);
                }
                apartmentList.add(apartment);
            }
        }
        StringBuilder stringServices = new StringBuilder("Количество доступных удобств: " + servicesMap.size() + "\n");
        for (String key : servicesMap.keySet()) {
            ArrayList<Apartment> value = servicesMap.get(key);
            stringServices
                    .append("Удобство \"")
                    .append(key)
                    .append("\" доступно в номерах:\n");
            for (Apartment apartment : value) {
                stringServices
                        .append("\t\u2219")
                        .append(apartment.getName())
                        .append(" (комната номер ")
                        .append(apartment.getNumberOfRoom())
                        .append(")\n");
            }
        }
        return stringServices.toString();
    }
}
