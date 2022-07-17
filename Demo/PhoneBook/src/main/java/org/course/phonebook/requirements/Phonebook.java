package org.course.phonebook.requirements;

import java.util.List;

public interface Phonebook {

    String getName();

    Contact addContact(Contact contact);

    Contact removeContact(Contact contact);

    Contact getContactById(int id);

    List<Contact> findContactsByName(String name);

    List<Contact> findContactsByPhone(String phone);

    List<String> getGroups();

    Phonebook exportPhonebook();

    void importPhonebook(Phonebook phonebook);

    List<Contact> findFriends(Phonebook phonebook);

    List<Contact> getContacts();
}
