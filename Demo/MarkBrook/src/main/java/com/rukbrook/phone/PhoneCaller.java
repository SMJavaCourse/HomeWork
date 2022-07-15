package com.rukbrook.phone;

import com.rukbrook.util.StringUtil;

public interface PhoneCaller {
    default void call() {
        System.out.println("Позвонил");
    }

    default void sms(String text, String address) {
        System.out.println("Отправил СМС с текстом: " + StringUtil.filter(text) + " абоненту с номером: " + address);
    }

    default void mms() {
        System.out.println("Отправил ММС");
    }

    default void flash() {
        System.out.println("Посветил фонариком");
    }

    void radio();

    default void radio(float frequency) {
        System.out.println("Включили радио на частоте " + frequency + " FM");
    }
}
