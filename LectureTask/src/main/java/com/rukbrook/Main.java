package com.rukbrook;

import com.rukbrook.builder.PhoneBuilder;
import com.rukbrook.exception.CourseException;
import com.rukbrook.factory.PhoneFactory;
import com.rukbrook.phone.MotorolaPhone;
import com.rukbrook.phone.NokiaPhone;
import com.rukbrook.phone.Phone;
import com.rukbrook.phone.music.Mp3Player;
import com.rukbrook.phone.music.WavPlayer;
import com.rukbrook.singleton.Singleton;

public class Main {
    public static void main(String[] args) {

//        PhoneFactory factory = new PhoneFactory();
//        try {
//            Phone motorolaPhone = factory.createPhone("MOTO");
//            motorolaPhone.play();
//
//            Phone ruNokiaPhone = factory.createPhone("NOKIA");
//            ruNokiaPhone.play();
//
//            Phone indiaNokiaPhone = new NokiaPhone(99.2, new WavPlayer());
//            indiaNokiaPhone.play();
//
//        } catch (CourseException e) {
//            e.printStackTrace();
//        }

//        PhoneBuilder builder = new PhoneBuilder();
//        Phone motorola = builder
//                .name("Motorola")
//                .frequency(104.2)
//                .build();
//
//        Phone nokia = builder
//                .name("Nokia")
//                .player(new Mp3Player())
//                .build();
//
//        Phone indianNokia = builder
//                .frequency(99.2)
//                .player(null)
//                .build();
//
//        System.out.println(motorola.getName());
//        System.out.println(motorola.getFrequency());
//        motorola.play();
//        System.out.println(nokia.getName());
//        System.out.println(nokia.getFrequency());
//        nokia.play();
//        System.out.println(indianNokia.getName());
//        System.out.println(indianNokia.getFrequency());
//        try {
//            play(indianNokia);
//        } catch (CourseException e) {
//            System.out.println("а плеера то нет");
//        }
//        Phone newPhone = builder.player(new WavPlayer()).build();

        Singleton singleton = Singleton.getInstance("первый раз");
        singleton.print();
        Singleton singleton2 = Singleton.getInstance("второй раз");
        singleton2.print();

//        Phone[] phones = new Phone[]{motorolaPhone, ruNokiaPhone, indiaNokiaPhone};
//
//        for (Phone phone : phones) {
//            sayHello(phone);
//        }

    }

    private static void play(Phone phone) {
        phone.play();
    }

    private static void sayHello(Phone phone) {
        if (phone instanceof MotorolaPhone) {
            ((MotorolaPhone) phone).helloMoto();
        }
        if (phone instanceof NokiaPhone) {
            ((NokiaPhone) phone).helloNokia();
        }
    }
}
