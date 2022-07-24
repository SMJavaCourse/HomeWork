package org.course.phonebook.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Demo_1 {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
//        ArrayList<String> strings = new ArrayList<>();
        strings.add("E");
        strings.add("D");
        strings.add("C");
        strings.add("C");
        strings.add("C");
        strings.add("A");
        strings.add("B");
        strings.add("B");

        String result = "";
//        for (int i = 0; i < strings.size(); i++) {
//            String str = strings.get(i);
//            result = result + str + " ";
//        }

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            result = result + str + " ";
        }


//        for (String str : strings) {
//            result = result + str + " ";
//        }
        System.out.println(result);

//        PhonebookImpl phonebook = new PhonebookImpl();
//        phonebook.addContact(new ContactImpl(1, "Стас Южаков", "+79992433131", null));
//        System.out.println("Add contact:" + phonebook);
//
//        Contact contact = phonebook.getContactById(1);
//        System.out.println("Get contact: " + contact);
//
//        phonebook.removeContact(contact);
//        System.out.println("Remove contact:" + phonebook);
    }
}
