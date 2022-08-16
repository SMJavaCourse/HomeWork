package org.course.utils;

import lombok.Getter;

@Getter
public enum CommandsEnum {

    EXIT("выход"),
    AMENITIES("удобства"),
    ;

    private final String name;

    CommandsEnum(final String name) {
        this.name = name;
    }
}
