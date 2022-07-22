package org.course.phonebook.impl;

import org.course.phonebook.requirements.Contact;

import java.util.List;


public class ContactImpl implements Contact {
    private int id;
    private String name;
    private String phone;
    private List<String> groups;

    public ContactImpl() {
    }

    public ContactImpl(int id, String name, String phone, List<String> groups) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.groups = groups;
    }

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
    public List<String> getGroups() {
        return groups;
    }

    @Override
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "ContactImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", groups=" + groups +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ContactImpl contact = (ContactImpl) o;

        if (id != contact.id)
            return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null)
            return false;
        if (phone != null ? !phone.equals(contact.phone) : contact.phone != null)
            return false;
        return groups != null ? groups.equals(contact.groups) : contact.groups == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (groups != null ? groups.hashCode() : 0);
        return result;
    }
}
