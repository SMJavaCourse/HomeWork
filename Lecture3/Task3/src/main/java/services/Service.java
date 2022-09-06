package services;

import lombok.Getter;

@Getter
public enum Service {
    AIRCONDITIONER("кондицонер"),
    BALCONY("балкон"),
    CLEANING("уборка номера"),
    INTERNET("интернет"),
    KEBAB("шашлычок в номер");

    private String name;

    Service (String name){
        this.name = name;
    }
}
