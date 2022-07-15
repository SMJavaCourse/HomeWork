package org.course.phonebook.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.course.phonebook.requirements.Contact;
import org.course.phonebook.requirements.Phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class PhonebookFastImpl implements Phonebook {

    private String name;
    private List<Contact> contacts;
    private Map<Integer, Contact> contactsById;

    public PhonebookFastImpl(int initial) {
        contacts = new ArrayList<>(initial);
        contactsById = new HashMap<>(initial);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Contact addContact(Contact contact) {
        contacts.add(contact);
        contactsById.put(contact.getId(), contact);
        return contacts.get(contacts.size() - 1);
    }

    @Override
    public Contact removeContact(Contact contact) {
        if (contacts.remove(contact)) {
            contactsById.remove(contact.getId());
        }
        return contact;
    }

    @Override
    public Contact getContactById(int id) {
        Contact result = contactsById.get(id);
        if (result != null) {
            return result;
        }
        throw new NoSuchElementException("Could not find contact with ID: " + id);
    }

    @Override
    public List<Contact> findContactsByName(String name) {
        List<Contact> returnContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(name.toLowerCase())) {
                returnContacts.add(contact);
            }
        }
        return returnContacts;
    }

    @Override
    public List<Contact> findContactsByPhone(String phone) {
        List<Contact> returnContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getPhone().toLowerCase().contains(phone.toLowerCase())) {
                returnContacts.add(contact);
            }
        }
        return returnContacts;
    }

    @Override
    public void importPhonebook(Phonebook phonebook) {
        this.contacts.addAll(phonebook.getContacts());
    }

    @Override
    public List<Contact> findFriends(Phonebook phonebook) {
        List<Contact> friends = new ArrayList<>(contacts);
        friends.retainAll(phonebook.getContacts());
        return friends;
    }

    @Override
    @JsonIgnore
    public List<String> getGroups() {
        Set<String> groups = new HashSet<>();
        for (Contact contact : contacts) {
            groups.addAll(contact.getGroups() != null ? contact.getGroups() : Collections.emptyList());
        }
        List<String> sortedGroups = new ArrayList<>(groups);
        Collections.sort(sortedGroups);
        return sortedGroups;
    }

    @Override
    public Phonebook exportPhonebook() {
        return this;
    }

    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "PhonebookImpl{" +
                "contacts=" + contacts +
                '}';
    }
}
