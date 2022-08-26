package org.course.phonebook.demo;

import org.course.phonebook.impl.ContactImpl;
import org.course.phonebook.impl.PhonebookImpl;
import org.course.phonebook.requirements.Contact;

import java.util.List;

public class Demo_3 {
    public static void main(String[] args) {
        PhonebookImpl myPhonebook = new PhonebookImpl();
        myPhonebook.addContact(new ContactImpl(1, "Стас Южаков", "+79992433131", null));
        myPhonebook.addContact(new ContactImpl(2, "Денис Белецкий", "+79991112233", null));
        myPhonebook.addContact(new ContactImpl(3, "Александр Елкин", "+79992223344", null));

        PhonebookImpl oldPhonebook = new PhonebookImpl();
        oldPhonebook.addContact(new ContactImpl(4, "Марк Брук", "+79994441111", null));
        oldPhonebook.addContact(new ContactImpl(5, "Дмитрий Лозицкий", "+79998882211", null));

        myPhonebook.importPhonebook(oldPhonebook);

        List<Contact> contacts = myPhonebook.getContacts();
        System.out.println("Import:\n" + contacts);
    }
}
