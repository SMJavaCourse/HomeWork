package org.course.phonebook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.math.NumberUtils;
import org.course.phonebook.impl.ContactImpl;
import org.course.phonebook.impl.PhonebookImpl;
import org.course.phonebook.requirements.Contact;
import org.course.phonebook.requirements.Phonebook;

import java.util.Scanner;

public class Application {

    private static Phonebook phonebook = new PhonebookImpl();
    private static final ObjectMapper MAPPER = new ObjectMapper();

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
                Contact getContact = getContact(commandWithArguments);
                if (getContact == null) {
                    return true;
                }
                System.out.println(getContact);
                break;
            case "remove":
                Contact removeContact = getContact(commandWithArguments);
                if (removeContact == null) {
                    return true;
                }
                System.out.println(phonebook.removeContact(removeContact));
                break;
            case "findName":
                if (!validateNumberOfArgs(commandWithArguments, 2)) {
                    return true;
                }
                Contact[] foundContactsByName = phonebook.findContactsByName(commandWithArguments[1]);
                for (int i = 0; i < foundContactsByName.length; i++) {
                    System.out.println(foundContactsByName[i]);
                }
                break;
            case "findPhone":
                if (!validateNumberOfArgs(commandWithArguments, 2)) {
                    return true;
                }
                Contact[] foundContactsByPhone = phonebook.findContactsByPhone(commandWithArguments[1]);
                for (int i = 0; i < foundContactsByPhone.length; i++) {
                    System.out.println(foundContactsByPhone[i]);
                }
                break;
            case "export":
                try {
                    String json = MAPPER.writeValueAsString(phonebook.exportPhonebook());
                    System.out.println(json);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "import":
                if (!validateNumberOfArgs(commandWithArguments, 2)) {
                    return true;
                }
                try {
                    phonebook = MAPPER.readValue(commandWithArguments[1], PhonebookImpl.class);
                    System.out.println("Successful");
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "list":
                PhonebookImpl phonebook = (PhonebookImpl) Application.phonebook;
                for (int i = 0; i < phonebook.getContacts().length; i++) {
                    System.out.println(phonebook.getContacts()[i]);
                }
                break;
            case "fill":
                fillPhonebook();
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
        contact = phonebook.addContact(contact);
        System.out.println(contact);

        Contact contact2 = new ContactImpl();
        contact2.setId(10);
        contact2.setName("Petya");
        contact2.setPhone("+79119005580");
        contact2 = phonebook.addContact(contact2);
        System.out.println(contact2);
    }

    private static boolean validateNumberOfArgs(String[] commandWithArguments, int expectedNumOfArgs) {
        if (commandWithArguments.length < expectedNumOfArgs) {
            System.out.println("Needs at least " + expectedNumOfArgs + " arguments");
            return false;
        }
        return true;
    }

    private static Contact getContact(String[] commandWithArguments) {
        if (!validateNumberOfArgs(commandWithArguments, 2)) {
            return null;
        }
        if (!NumberUtils.isCreatable(commandWithArguments[1])) {
            System.out.println("ID shouldn't be String");
            return null;
        }
        int id = Integer.parseInt(commandWithArguments[1]);
        return phonebook.getContactById(id);
    }
}
