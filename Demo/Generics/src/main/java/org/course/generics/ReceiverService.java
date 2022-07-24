package org.course.generics;

public class ReceiverService {
    public <V> V receive(Box<V> box) {
        V delivery = box.getDelivery();
        return delivery;
    }
}
