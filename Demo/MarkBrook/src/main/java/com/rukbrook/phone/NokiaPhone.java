package com.rukbrook.phone;

import com.rukbrook.phone.music.Player;

public class NokiaPhone extends Phone {

    public NokiaPhone(double frequency, Player player) {
        super(frequency, "Nokia", player);
    }

    public void soutName() {
        System.out.println(name);
    }

    public void helloNokia() {
        System.out.println("Hello Nokia");
    }
}
