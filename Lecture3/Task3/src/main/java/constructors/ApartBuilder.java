package constructors;

import org.course.Apartment;

public class ApartBuilder {
    private int num;
    private int rooms;
    private float price;
    private String time;
    private int people;
    
    private boolean isBalcony;
    private boolean isClean;
    private boolean isInternet;
    private boolean isAirConditioner;
    private boolean isKebab;

    public ApartBuilder() {
    }

    public ApartBuilder num(int num) {
        this.num = num;
        return this;
    }

    public ApartBuilder rooms(int rooms) {
        this.rooms = rooms;
        return this;
    }

    public ApartBuilder price(float price) {
        this.price = price;
        return this;
    }

    public ApartBuilder time(String time) {
        this.time = time;
        return this;
    }

    public ApartBuilder capacity(int people) {
        this.people = people;
        return this;
    }

    public ApartBuilder isBalcony(boolean isBalcony) {
        this.isBalcony = isBalcony;
        return this;
    }

    public ApartBuilder isClean(boolean isClean) {
        this.isClean = isClean;
        return this;
    }

    public ApartBuilder isInternet(boolean isInternet) {
        this.isInternet = isInternet;
        return this;
    }

    public ApartBuilder isAirConditioner(boolean isAirConditioner) {
        this.isAirConditioner = isAirConditioner;
        return this;
    }

    public ApartBuilder isKebab(boolean isKebab) {
        this.isKebab = isKebab;
        return this;
    }

    public Apartment build() {
        return new Apartment(num, rooms, price, time, people, isBalcony, isClean, isInternet, isAirConditioner, isKebab);
    }
}
