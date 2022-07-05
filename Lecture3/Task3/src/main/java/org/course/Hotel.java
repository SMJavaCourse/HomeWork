package org.course;

public class Hotel {
    private String name;
    private Apartment[] apartments;
    private String startTime;

    public Hotel(String name, String startTime,Apartment[] apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String text = "Отель \"" + name + "\"" + "\n" +
                "Количество номеров: " + apartments.length + "\n" +
                "Время заселение/выселения: " + startTime + "\n" +
                "Номера:" + "\n";
        for (int i = 0; i < apartments.length; i++) {
            text += apartments[i].toString();
        }
        return text;
    }
}
