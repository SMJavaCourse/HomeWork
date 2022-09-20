package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Locale;

@Getter
public class MainData {
    String nameOfHotels;
    Command commandInput;
    String errorMessage;
    int numberOfGuests;

    public MainData(String nameOfHotels, Command commandInput, String errorMessage, int numberOfGuests) {
        this.nameOfHotels = nameOfHotels;
        this.commandInput = commandInput;
        this.errorMessage = errorMessage;
        this.numberOfGuests = numberOfGuests;
    }

    private MainData() {

    }

    public static MainData numberOfGuestsMainData(int numberOfGuests) {
        MainData md = new MainData();
        md.numberOfGuests = numberOfGuests;
        return md;
    }

    public static MainData errorMainData(String errorMessage) {
        MainData md = new MainData();
        md.errorMessage = errorMessage;
        return md;
    }
    public static MainData commandMainData(Command commandInput) {
        MainData md = new MainData();
        md.commandInput = commandInput;
        return md;
    }
}
