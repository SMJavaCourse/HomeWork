package constructors;

import org.course.Apartment;

public class ApartBuilder {
    public int num;
    public int apartment;
    public float price;
    public String time;
    private int people;

    public boolean isBalcony;
    public boolean isClean;
    public boolean isInternet;
    public boolean isСonditioner;
    public boolean isShashlik;


    public ApartBuilder num(int num) {
        this.num = num;
        return this;
    }

    public ApartBuilder apartment(int apartment) {
        this.apartment = apartment;
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

    public ApartBuilder isСonditioner(boolean isСonditioner) {
        this.isСonditioner = isСonditioner;
        return this;
    }

    public ApartBuilder isShashlik(boolean isShashlik) {
        this.isShashlik = isShashlik;
        return this;
    }

    public Apartment build() {
        return new Apartment(num, apartment, price, time, people, isBalcony, isClean, isInternet, isСonditioner, isShashlik);
    }
}
