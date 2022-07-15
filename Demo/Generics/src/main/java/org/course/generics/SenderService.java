package org.course.generics;

import org.course.generics.items.Car;
import org.course.generics.items.Chair;
import org.course.generics.items.Stone;
import org.course.generics.items.Water;

public class SenderService {
    public Box<Car> send(Car car) {
        System.out.println("Sending car");
        Box<Car> box = new Box<>(Box.Size.XL);
        box.setDelivery(car);
        return box;
    }

    public Box<Stone> send(Stone stone) {
        System.out.println("Sending stone");
        Box<Stone> box = new Box<>(Box.Size.M);
        box.setDelivery(stone);
        return box;
    }

    public <T extends Water> Cistern<T> send(T water) {
        System.out.println("Sending water");
        Cistern<T> cistern = new Cistern<>(Box.Size.S);
        cistern.setDelivery(water);
        return cistern;
    }

    public Box<Chair> send(Chair chair) {
        System.out.println("Sending chair");
        Box<Chair> box = new Box<>(Box.Size.M);
        box.setDelivery(chair);
        return box;
    }
}
