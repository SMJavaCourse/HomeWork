package com.rukbrook.factory;

import com.rukbrook.exception.CourseException;
import com.rukbrook.phone.MotorolaPhone;
import com.rukbrook.phone.NokiaPhone;
import com.rukbrook.phone.Phone;
import com.rukbrook.phone.music.Mp3Player;
import com.rukbrook.phone.music.WavPlayer;

public class PhoneFactory {

    public Phone createPhone(String model) throws CourseException {
        switch (model) {
            case "MOTO" :
                return new MotorolaPhone(102.4, new Mp3Player());
            case "NOKIA":
                return new NokiaPhone(102.4, new Mp3Player());
            case "INDIA_NOKIA":
                return new NokiaPhone(103.3, new WavPlayer());
        }
        throw new CourseException("неверная модель телефона");
    }
}
