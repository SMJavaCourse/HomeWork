package dto;

import lombok.Getter;

@Getter
public enum Command {
    EXIT("выход"),
    FACILITIES("удобства");

    public final String name;

    Command(String name) {
        this.name = name;
    }
}
