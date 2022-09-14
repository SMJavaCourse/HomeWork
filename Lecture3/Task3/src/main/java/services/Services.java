package services;

import lombok.Getter;

@Getter
public enum Services {
    AIRCONDITIONER("кондицонер"),
    BALCONY("балкон"),
    CLEANING("уборка номера"),
    INTERNET("интернет"),
    KEBAB("шашлычок в номер");

    private String name;

    Services (String name){
        this.name = name;
    }
}
