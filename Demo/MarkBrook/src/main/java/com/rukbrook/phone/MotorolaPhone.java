package com.rukbrook.phone;

import com.rukbrook.phone.music.Player;

public class MotorolaPhone extends Phone {

    public MotorolaPhone(double frequency, Player player) {
        super(frequency, "Motorola", player);
    }

    public void soutName() {
        System.out.println(name);
    }

    public void helloMoto() {
        System.out.println("Hello Moto!");
    }
}
