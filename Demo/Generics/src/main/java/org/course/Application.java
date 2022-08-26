package org.course;

import org.course.generics.Cistern;
import org.course.generics.ReceiverService;
import org.course.generics.SenderService;
import org.course.generics.items.Coffee;
import org.course.generics.items.Water;

public class Application {
    private static SenderService senderService = new SenderService();
    private static ReceiverService receiverService = new ReceiverService();

    public static void main(String[] args) {
//        Cistern<Water> carCistern = new Cistern<>(null);
//        carCistern.setDelivery(new Water());

        Cistern<?> box = senderService.send(new Coffee());
        Object delivery = box.getDelivery();
        Water received = receiverService.receive(box);
        received.squish();
    }
}
