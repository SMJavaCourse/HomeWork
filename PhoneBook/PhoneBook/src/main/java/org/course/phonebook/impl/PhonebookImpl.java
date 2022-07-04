package org.course.phonebook.impl;

import org.course.phonebook.requirements.Contact;
import org.course.phonebook.requirements.Phonebook;

import java.util.NoSuchElementException;

public class PhonebookImpl implements Phonebook {

    private String name;
    private Contact[] contacts;


    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact[] getContacts() {
        return contacts;
    }

    @Override
    public Contact addContact(Contact contact) {
        if (contacts == null) {
            contacts = new ContactImpl[1];
            contacts[0] = contact;
        } else {
            Contact[] newContacts = new ContactImpl[contacts.length + 1];
            newContacts[contacts.length] = contact;
            System.arraycopy(contacts, 0, newContacts, 0, contacts.length);
            contacts = newContacts;
        }
        return contacts[contacts.length - 1];
    }

    @Override
    public Contact removeContact(Contact contact) {
        return null;
    }

    @Override
    public Contact getContactById(int id) {
        for (int i = 0; i < this.contacts.length; i++) {
            if (contacts[i].getId() != id) {
                continue;
            }
            return contacts[i];
        }
        throw new NoSuchElementException("Could not find contact with ID: " + id);
    }

    @Override
    public Contact[] findContactsByName(String name) {
        return new Contact[0];
    }

    @Override
    public Contact[] findContactsByPhone(String phone) {
        return new Contact[0];
    }

    @Override
    public String[] getGroups() {
        return new String[0];
    }

    @Override
    public Phonebook exportPhonebook() {
        return null;
    }

    @Override
    public void importPhonebook(Phonebook phonebook) {

    }

    @Override
    public Contact[] findFriends(Phonebook phonebook) {
        return new Contact[0];
    }
}
