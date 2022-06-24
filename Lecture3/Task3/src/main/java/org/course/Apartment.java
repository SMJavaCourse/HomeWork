package main.java.org.course;

import java.time.LocalTime;

public abstract class Apartment implements Apartments {
    private boolean balcony;
    private boolean internet;
    private boolean conditioner;
    private boolean cleaning;
    private boolean grillMeat;

    private float price;
    private int places;
    private int roomNumber;

    private LocalTime checkinTime;

    public float getPrice() {
        return price;
    }

    public int getPlaces() {
        return places;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Apartment(float price, int places, int roomNumber) {
        this.price = price;
        this.places = places;
        this.roomNumber = roomNumber;
    }

    public void setCheckinTime(LocalTime checkinTime) {
        this.checkinTime = checkinTime;
    }

    public LocalTime getCheckinTime() {
        return checkinTime;
    }

    public boolean isGrillMeat() {
        return grillMeat;
    }

    public Apartment addGrillMeat() {
        this.grillMeat = true;
        return this;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public Apartment addBalcony() {
        this.balcony = true;
        return this;
    }

    public boolean isInternet() {
        return internet;
    }

    public Apartment addInternet() {
        this.internet = true;
        return this;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    public Apartment addConditioner() {
        this.conditioner = true;
        return this;
    }

    public boolean isCleaning() {
        return cleaning;
    }

    public Apartment addCleaning() {
        this.cleaning = true;
        return this;
    }

    @Override
    public String toString() {
        return getApartmentsTypeName() + " (комната номер " + getRoomNumber() + "): \n" +
                "\tЦена: " + getPrice() + "\n" +
                "\tВместительность: " + getPlaces() + "\n" +
                "\tВремя заселение/выселения: " + getCheckinTime() + "\n" +
                "\tДополнительные услуги: " + (isBalcony() ? "Балкон " : "") +
                (isCleaning() ? "Уборка " : "") +
                (isInternet() ? "Интернет " : "") +
                (isConditioner() ? "Кондиционер " : "") +
                (isGrillMeat() ? "Шашлычок в номер:D " : "");
    }

}
