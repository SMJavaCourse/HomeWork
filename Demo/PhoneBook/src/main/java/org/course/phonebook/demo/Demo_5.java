package org.course.phonebook.demo;

import org.course.phonebook.impl.ContactImpl;
import org.course.phonebook.impl.PhonebookImpl;

import java.util.List;

public class Demo_5 {
    public static void main(String[] args) {
        PhonebookImpl myPhonebook = new PhonebookImpl();
        myPhonebook.addContact(new ContactImpl(1, "Стас Южаков", "+79992433131", null));
        myPhonebook.addContact(new ContactImpl(2, "Денис Белецкий", "+79991112233", List.of("Java")));
        myPhonebook.addContact(new ContactImpl(3, "Александр Елкин", "+79992223344", List.of("Architects")));
        myPhonebook.addContact(new ContactImpl(4, "Марк Брук", "+79994441111", List.of("Java", "Пиво")));
        myPhonebook.addContact(new ContactImpl(5, "Дмитрий Лозицкий", "+79998882211", List.of("Java", "Пиво")));

        List<String> groups = myPhonebook.getGroups();
        System.out.println("All groups:\n" + groups);
    }
}
