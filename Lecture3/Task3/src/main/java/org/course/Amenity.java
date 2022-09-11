package org.course;

public enum Amenity {
    BALCONY("балкон"),
    CLEANING("уборка в номере"),
    INTERNET("интернет"),
    COOLING("кондиционер"),
    GRILL("шашлык в постель");
    private final String name;

    Amenity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
