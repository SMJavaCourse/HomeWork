package org.course.phonebook.demo;

import org.course.phonebook.impl.ContactImpl;
import org.course.phonebook.impl.PhonebookImpl;
import org.course.phonebook.requirements.Contact;

import java.util.List;

public class Demo_2 {
    public static void main(String[] args) {
        PhonebookImpl phonebook = new PhonebookImpl();
        phonebook.addContact(new ContactImpl(1, "Стас Южаков", "+79992433131", null));
        phonebook.addContact(new ContactImpl(2, "Денис Белецкий", "+79991112233", null));
        phonebook.addContact(new ContactImpl(3, "Александр Елкин", "+79992223344", null));
        List<Contact> denis = phonebook.findContactsByName("Денис Белецкий");
        System.out.println("Денис: " + denis);
        List<Contact> sasha = phonebook.findContactsByPhone("+79992223344");
        System.out.println("Саша: " + sasha);
    }
}
