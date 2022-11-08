package org.course;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;
import java.util.List;


@Getter
public class HotelImpl implements Hotels, Comparable{
    private String name;
    private LocalTime checkInTime;
    private List<Apartment> apartments;
    private Integer roomsTotalCount;


    @Builder
    public HotelImpl(String name, List<Apartment> apartments, LocalTime checkInTime) {
        this.name = name;
        this.apartments = apartments;
        this.checkInTime = checkInTime;
        try {
            if(apartments == null) {
                throw new HotelException("No apartments");
            }
            this.roomsTotalCount = apartments.size();
            apartments.forEach(a -> a.setCheckinTime(checkInTime));

        } catch (HotelException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Отель \"" + this.name + "\""  + ":\n" +
                "Количество номеров: " + this.roomsTotalCount + "\n" +
                "Номера: ";
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((HotelImpl) o).getName());
    }

}
