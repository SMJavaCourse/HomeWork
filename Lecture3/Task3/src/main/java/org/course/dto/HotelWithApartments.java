package org.course.dto;

import lombok.Builder;
import lombok.Data;
import org.course.Apartment;
import org.course.Hotel;

import java.util.List;

@Data
@Builder
public class HotelWithApartments { // ???
    private Hotel hotel;
    private List<Apartment> apartments;

}
