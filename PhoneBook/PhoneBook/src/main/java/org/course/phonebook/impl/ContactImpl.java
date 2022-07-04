package org.course.phonebook.impl;

import org.course.phonebook.requirements.Contact;

import java.util.Arrays;

public class ContactImpl implements Contact {

    private int id;
    private String name;
    private String phone;
    private String[] groups;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String[] getGroups() {
        return groups;
    }

    @Override
    public void setGroups(String[] groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "ContactImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
