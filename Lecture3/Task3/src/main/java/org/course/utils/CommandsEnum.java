package org.course.utils;

public enum CommandsEnum {

    EXIT("выход"),
    AMENITIES("удобства"),
    ;

    private final String name;

    CommandsEnum(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
