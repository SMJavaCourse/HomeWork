package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MainData {
    String nameOfHotels;
    String commandInput;
    String errorMessage;
    int numberOfGuests;
}
