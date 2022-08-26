package org.course.generics;

public class Box<T> {
    private Size size;
    private T delivery;

    public Box(Size size) {
        this.size = size;
    }

    public T getDelivery() {
        return delivery;
    }

    public void setDelivery(T delivery) {
        this.delivery = delivery;
    }

    public enum Size {
        S, M, XL
    }
}
