package org.course.phonebook;

import org.apache.commons.lang3.math.NumberUtils;
import org.course.phonebook.impl.ContactImpl;
import org.course.phonebook.impl.PhonebookImpl;
import org.course.phonebook.requirements.Contact;
import org.course.phonebook.requirements.Phonebook;

import java.util.Scanner;

public class Application {

    private static final Phonebook PHONEBOOK = new PhonebookImpl();

    public static void main(String[] args) {
        fillPhonebook();

        Scanner in = new Scanner(System.in);
        boolean continueApp = true;
        while (continueApp) {
            System.out.print("Please, input command: ");
            String value = in.nextLine();
            if (value == null) {
                System.out.println("Command cannot be null");
                continue;
            }

            String[] commandWithArguments = value.trim().split(" ");
            continueApp = processCommandAndContinue(commandWithArguments);
        }
        in.close();
    }

    /**
     * Метод обрабатывает входящую команду с аргументами и решает вопрос о продолжении работы приложения
     *
     * @param commandWithArguments Команда с аргументами
     * @return Флаг того, необходимо ли продолжать работу
     */
    public static boolean processCommandAndContinue(String[] commandWithArguments) {
        if (commandWithArguments.length < 1) {
            System.out.println("Command not found");
            return true;
        }
        String command = commandWithArguments[0];

        switch (command) {
            case "exit":
                return false;
            case "get":
                if (commandWithArguments.length < 2) {
                    System.out.println("Could not find ID of contact");
                    return true;
                }
                if (!NumberUtils.isCreatable(commandWithArguments[1])) {
                    System.out.println("ID shouldn't be String");
                    return true;
                }
                int id = Integer.parseInt(commandWithArguments[1]);
                Contact contact = PHONEBOOK.getContactById(id);
                System.out.println(contact);
                break;
            default:
                System.out.println("Unknown command!");
        }
        return true;
    }

    public static void fillPhonebook() {
        Contact contact = new ContactImpl();
        contact.setId(5);
        contact.setName("Vasya");
        contact.setPhone("+79119005585");
        contact = PHONEBOOK.addContact(contact);
        System.out.println(contact);

        Contact contact2 = new ContactImpl();
        contact2.setId(10);
        contact2.setName("Petya");
        contact2.setPhone("+79119005580");
        contact2 = PHONEBOOK.addContact(contact2);
        System.out.println(contact2);
    }
}
