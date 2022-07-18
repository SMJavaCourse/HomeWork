package org.course.phonebook.old;

import org.course.phonebook.requirements.Contact;

public interface OldPhonebook {

    String getName();

    Contact addContact(Contact contact);

    Contact removeContact(Contact contact);

    Contact getContactById(int id);

    Contact[] findContactsByName(String name);

    Contact[] findContactsByPhone(String phone);

    String[] getGroups();

    OldPhonebook exportPhonebook();

    void importPhonebook(OldPhonebook phonebook);

    Contact[] findFriends(OldPhonebook phonebook);
}
