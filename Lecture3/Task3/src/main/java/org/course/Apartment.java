package org.course;

public abstract class Apartment {
    protected double price;
    private boolean internet;
    private boolean cleaning;
    private boolean balcony;
    private boolean airConditioner;
    private boolean kebab;


    private final int numberOfRoom;


    public Apartment(double price, int numberOfRoom) {
        this.price = price;
        this.numberOfRoom = numberOfRoom;
    }
    public double getPrice(){
        return this.price;
    }

    public int getNumberOfRoom(){
        return numberOfRoom;
    }

    public String getNameOfApartment(){
        return "Апартаменты";
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public String isInternet() {
        if (internet) {
            return "Интернет";
        } else
            return "";
    }

    public String isBalcony() {
        if (balcony) {
            return "Балкон";
        } else
            return "";
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public static void printApartmentsInfo(Apartment[] apartmentsHotel){
        System.out.println("Количество номеров: " + apartmentsHotel.length);
        System.out.println("Номера:");
        for (Apartment apartment : apartmentsHotel) {
            System.out.println(apartment.getNameOfApartment() + " (комната номер " + apartment.getNumberOfRoom() + "):");
            //System.out.println(apartment.getPrice() + " " + apartment.getNumberOfRoom());
            System.out.println("Дополнительные услуги: " +
                    apartment.isBalcony() + " " +
                    apartment.isInternet() + " " +
                    apartment.isCleaning() + " " +
                    apartment.isKebab() + " " +
                    apartment.isAirConditioner());
        }
        System.out.println();
    }


    public String isCleaning() {
        if (cleaning) {
            return "Уборка номера";
        } else
            return "";
    }

    public void setCleaning(boolean cleaning) {
        this.cleaning = cleaning;
    }

    public String isAirConditioner() {
        if (airConditioner) {
            return "Кондиционер";
        } else
            return "";
    }

    public void setAirConditioner(boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public String isKebab() {
        if (kebab) {
            return "Уборка номера";
        } else
            return "";
    }

    public void setKebab(boolean kebab) {
        this.kebab = kebab;
    }
}

