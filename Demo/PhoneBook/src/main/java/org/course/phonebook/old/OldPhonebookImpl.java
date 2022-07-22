package org.course.phonebook.old;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.course.phonebook.impl.ContactImpl;
import org.course.phonebook.requirements.Contact;

import java.util.NoSuchElementException;

public class OldPhonebookImpl implements OldPhonebook {

    private String name;
    private Contact[] contacts = new Contact[0];


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
        int index = 10;
        for (int i = 0; i < this.contacts.length; i++) {
            if (this.contacts[i].getId() != contact.getId()) {
                continue;
            }
            index = i;
            break;
        }
        this.contacts[index] = this.contacts[contacts.length - 1];
        Contact[] newContacts = new ContactImpl[contacts.length - 1];
        System.arraycopy(this.contacts, 0, newContacts, 0, this.contacts.length - 1);
        this.contacts = newContacts;
        return contact;
    }

//    @Override
//    public Contact removeContact(Contact contact) {
//        int index = 10;
//        for (int i = 0; i < this.contacts.length; i++) {
//            if (this.contacts[i].getId() != contact.getId()) {
//                continue;
//            }
//            index = i;
//            break;
//        }
//        Contact[] newContacts = new ContactImpl[contacts.length - 1];
//        System.arraycopy(this.contacts, 0, newContacts, 0, index);
//        System.arraycopy(this.contacts, index + 1, newContacts, index, this.contacts.length - index - 1);
//        this.contacts = newContacts;
//        return contact;
//    }

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
        Contact[] foundContacts = new ContactImpl[this.contacts.length];
        int foundIndex = 0;
        for (int i = 0; i < this.contacts.length; i++) {
            if (this.contacts[i].getName().toLowerCase().contains(name.toLowerCase())) {
                foundContacts[foundIndex] = this.contacts[i];
                foundIndex++;
            }
        }
        Contact[] returnContacts = new ContactImpl[foundIndex];
        System.arraycopy(foundContacts, 0, returnContacts, 0, returnContacts.length);
        return returnContacts;
    }

    @Override
    public Contact[] findContactsByPhone(String phone) {
        Contact[] foundContacts = new ContactImpl[this.contacts.length];
        int foundIndex = 0;
        for (int i = 0; i < this.contacts.length; i++) {
            if (this.contacts[i].getPhone().toLowerCase().contains(phone.toLowerCase())) {
                foundContacts[foundIndex] = this.contacts[i];
                foundIndex++;
            }
        }
        Contact[] returnContacts = new ContactImpl[foundIndex];
        System.arraycopy(foundContacts, 0, returnContacts, 0, returnContacts.length);
        return returnContacts;
    }

    @Override
    @JsonIgnore
    public String[] getGroups() {
        return new String[0];
    }

    @Override
    public OldPhonebook exportPhonebook() {
        return this;
    }

    @Override
    public void importPhonebook(OldPhonebook phonebook) {

    }

    @Override
    public Contact[] findFriends(OldPhonebook phonebook) {
        return new Contact[0];
    }
}

