package org.course;

public class RoomBuilder {
    private int num;
    private int room;
    private float price;
    private String time;
    private int capacity;
    private boolean isBal;
    private boolean isClean;
    private boolean isInternet;
    private boolean isCondei;
    private boolean isShashl;
    private Facility[] facilities = new Facility[0];


    public RoomBuilder capacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Room build() {
        return new Room(capacity);
    }


}
