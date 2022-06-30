package org.course.phonebook.requirements;

public interface Phonebook {

    String getName();

    Contact addContact(Contact contact);

    Contact removeContact(Contact contact);

    Contact getContactById(int id);

    Contact[] findContactsByName(String name);

    Contact[] findContactsByPhone(String phone);

    String[] getGroups();

    Phonebook exportPhonebook();

    void importPhonebook(Phonebook phonebook);

    Contact[] findFriends(Phonebook phonebook);
}
