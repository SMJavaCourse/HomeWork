package com.rukbrook.builder;

import com.rukbrook.phone.Phone;
import com.rukbrook.phone.music.Player;

public class PhoneBuilder {

    private double frequency;
    private String phoneName;
    private Player player;

    public PhoneBuilder frequency(double frequency) {
        this.frequency = frequency;
        return this;
    }

    public PhoneBuilder name(String phoneName) {
        this.phoneName = phoneName;
        return this;
    }

    public PhoneBuilder player(Player player) {
        this.player = player;
        return this;
    }

    public Phone build() {
        return new Phone(frequency, phoneName, player);
    }

}
