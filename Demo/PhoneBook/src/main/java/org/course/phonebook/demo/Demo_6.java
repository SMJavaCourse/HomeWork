package org.course.phonebook.demo;

import org.course.phonebook.impl.ContactImpl;
import org.course.phonebook.impl.PhonebookImpl;
import org.course.phonebook.requirements.Contact;
import org.course.phonebook.requirements.Phonebook;

public class Demo_6 {
    public static void main(String[] args) {
        Phonebook myPhonebook = new PhonebookImpl();
        for (int i = 0; i < 50_000_001; i++) {
            myPhonebook.addContact(new ContactImpl(i, "Стас Южаков", "+79992433131", null));
        }

        System.out.println("Start get");
        long start = System.currentTimeMillis();
        Contact contact = myPhonebook.getContactById(50_000_000);
        long end = System.currentTimeMillis() - start;
        System.out.printf("Found in %sms: %s\n", end, contact);
    }
}
