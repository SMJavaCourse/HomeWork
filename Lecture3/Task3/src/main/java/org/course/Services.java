package org.course;

public class Services implements Interface {
    private String description;

    public Services(String name) {
        this.description = name;
    }

    public String getUslugaName() {
        return description;
    }

    @Override
    public String toString() {
        return description+" ";
    }
}
