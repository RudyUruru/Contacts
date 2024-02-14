import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private static final List<Person> contacts = new ArrayList<>();
    private static final String BACK_TO_MENU = "Возвращение в главное меню...";

    public static void savePerson() throws IOException {
        Person person = PersonFactory.createPerson();
        contacts.add(person);
        System.out.println("Контакт сохранен!");
        System.out.println(BACK_TO_MENU);
    }

    public static void printAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Ваш список контактов пуст.");
            System.out.println(BACK_TO_MENU);
            return;
        }
        System.out.println("Список контактов: ");
        for (int i = 0; i < contacts.size(); i++) {
            printContactById(i);
        }

        System.out.println(BACK_TO_MENU);
    }

    public static void printContactById(int id) {
        Person person = getContactById(id);
        StringBuilder result = new StringBuilder();
        id += 1;
        result.append(id).append(". ").append(person.getName()).append(" ");
        if (!person.getSurname().isEmpty()) {
            result.append(person.getSurname()).append(" ");
        }
        result.append("|| ").append(person.getPhoneNumber());
        if (!person.getEmail().isEmpty())
            result.append(" || ").append(person.getEmail());
        System.out.println(result);
    }

    public static Person getContactById(int id) {
        return contacts.get(id);
    }

    public static void searchContactByName() throws IOException {
        System.out.println("\nПоиск контакта...");
        if (contacts.isEmpty()) {
            System.out.println("Ваш список контактов пуст.");
            System.out.println(BACK_TO_MENU);
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите первые символы либо имя целиком: ");
        String name = reader.readLine().toLowerCase();
        System.out.println("Результаты поиска:");
        for (int i = 0; i < contacts.size(); i++) {
            if (getContactById(i).getName().toLowerCase().startsWith(name)) {
                printContactById(i);
            }
        }
        System.out.println(BACK_TO_MENU);
    }

    public static void deleteContactById() throws IOException {
        System.out.println("\nУдаление контакта...");
        if (contacts.isEmpty()) {
            System.out.println("Ваш список контактов пуст.");
            System.out.println(BACK_TO_MENU);
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите номер контакта для удаления: ");
        int id = Integer.parseInt(reader.readLine());

        if (id < 1 || id > contacts.size()) {
            System.out.println("Контакта с таким номером не существует.");
            return;
        }
        id -= 1;
        Person person = getContactById(id);
        System.out.println("Контакт \"" + person.getName() + " " + person.getSurname() + "\" успешно удален.");
        contacts.remove(id);
        System.out.println(BACK_TO_MENU);
    }
}
