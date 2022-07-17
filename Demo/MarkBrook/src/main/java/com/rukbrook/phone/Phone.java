package com.rukbrook.phone;

import com.rukbrook.exception.CourseException;
import com.rukbrook.phone.music.Player;

public class Phone implements PhoneCaller, Player {

    private double frequency;
    protected String name;
    private Player player;

    public Phone(double frequency, String name, Player player) {
        this.frequency = frequency;
        this.name = name;
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void radio() {
        System.out.println("Включили радио на частоте " + frequency + " FM");
    }

    public double getFrequency() {
        return frequency;
    }

    public void play() throws CourseException {
        if (player != null) {
            player.play();
        } else {
            throw new CourseException("нет плеера");
        }
    }

}
