package org.course.phonebook.demo;

import org.course.phonebook.impl.ContactImpl;
import org.course.phonebook.requirements.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo_7 {
    public static void main(String[] args) {
        List<Contact> contacts = List.of(new ContactImpl(1, "Стас Южаков", "+79992433131", List.of()),
                new ContactImpl(2, "Денис Белецкий", "+79991112233", List.of("Java")),
                new ContactImpl(3, "Александр Елкин", "+79992223344", List.of("Architects")),
                new ContactImpl(4, "Марк Брук", "+79994441111", List.of("Java", "Пиво")),
                new ContactImpl(5, "Дмитрий Лозицкий", "+79998882211", List.of("Java", "Пиво")));

        HashMap<String, List<Contact>> groupsMap = new HashMap<>();
        //Складываем контакты по группам
        for (Contact contact : contacts) {
            for (String group : contact.getGroups()) {
                List<Contact> groupContacts = groupsMap.get(group);
                //noinspection
                if (groupContacts == null) {
                    groupContacts = new ArrayList<>();
                    groupsMap.put(group, groupContacts);
                }
                groupContacts.add(contact);
            }
        }

        //Смотрим все группы и ищем самую большую
        Map.Entry<String, List<Contact>> biggest = null;
        for (Map.Entry<String, List<Contact>> entry : groupsMap.entrySet()) {
            if (biggest == null) {
                biggest = entry;
                continue;
            }
            int biggestSize = biggest.getValue().size();
            int currentSize = entry.getValue().size();
            if (currentSize > biggestSize) {
                biggest = entry;
            }
        }

        //Выводим самую большую группу
        System.out.printf("Biggest group is '%s': %s", biggest.getKey(), biggest.getValue());
    }
}
