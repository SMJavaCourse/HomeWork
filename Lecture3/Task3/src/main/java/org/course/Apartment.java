package org.course;

public  class Apartment {




    private int amount;
    private int price;
    private int roomsCount;
    private boolean balcon;
    private boolean clening;
    private boolean internet;
    private boolean cooling;
    private boolean grillInNumber;



    public Apartment(int amount, int price, int roomsCount, boolean balcon, boolean clening, boolean internet, boolean cooling, boolean grillInNumber) {
        this.amount = amount;
        this.price = price;
        this.roomsCount = roomsCount;
        this.balcon = balcon;
        this.clening = clening;
        this.internet = internet;
        this.cooling = cooling;
        this.grillInNumber = grillInNumber;

    }
    public boolean isBalcon() {
        return balcon;
    }

    public boolean isClening() {
        return clening;
    }

    public boolean isInternet() {
        return internet;
    }

    public boolean isCooling() {
        return cooling;
    }

    public boolean isGrillInNumber() {
        return grillInNumber;
    }
    public int getRoomsCount() {
        return roomsCount;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "amount=" + amount +
                ", price=" + price +
                ", вместимость=" + roomsCount + " человек" +
                ", балкон=" + balcon +
                ", уборка номера=" + clening +
                ", интернет=" + internet +
                ", кондей=" + cooling +
                ", шашлык в номер=" + grillInNumber +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "Apartment{" +
//                "amount=" + amount +
//                ", price=" + price +
//                '}';
//    }

}