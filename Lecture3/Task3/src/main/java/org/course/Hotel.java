package org.course;

public class Hotel {
    private String name;
    private Apartment[] apartments;
    private final String checkInTime;


    public String getCheckInTime() {
        return checkInTime;
    }

    public Hotel(String name, Apartment[] apartments, String checkInTime) {
        this.name = name;
        this.apartments = apartments;
        this.checkInTime = checkInTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void setRooms(Apartment[] apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        String text = "Отель: " + this.getName() + System.lineSeparator() +
                "Время заселения: " + this.getCheckInTime() + System.lineSeparator() +
                "Количество номеров: " + apartments.length + System.lineSeparator() +
                "Номера: " + System.lineSeparator();
        for (int i = 0; i < apartments.length; i++) {
            text += apartments[i].toString() + System.lineSeparator() +
                    " - Время заселение/выселения: " + this.getCheckInTime() + System.lineSeparator();
        }
        return text;
    }
}
