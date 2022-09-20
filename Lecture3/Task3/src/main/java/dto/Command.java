package dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public enum Command {
    EXIT_RU("выход"),
    EXIT_EN("exit"),
    FACILITIES("удобства");

    public final String name;

    Command(String name) {
        this.name = name;
    }

}
