package org.course;

public enum Facility {
    BALCONY("балкон"),
    AIR_CONDITIONING("кондиционер"),
    CLEANING("уборка номера"),
    INTERNET("интернет"),
//    SHASHLIK("шашлык")
    ;

    private String name;

    Facility(String name) {
        this.name = name;
    }
}
