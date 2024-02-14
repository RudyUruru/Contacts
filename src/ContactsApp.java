import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContactsApp {
    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать в приложение \"Cписок контактов\"!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int actionNumber = 0;

        while (actionNumber != 5) {
            System.out.println("\n1) Добавить контакт");
            System.out.println("2) Просмотреть список контактов");
            System.out.println("3) Найти контакт по имени");
            System.out.println("4) Удалить контакт");
            System.out.println("5) Выйти из приложения");
            System.out.print("\nВведите номер действия: ");
            try {
                actionNumber = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести число!");
                continue;
            }
            if (Validator.isActionNumberValid(actionNumber)) {
                switch(actionNumber) {
                    case 1: Processor.savePerson(); break;
                    case 2: Processor.printAllContacts(); break;
                    case 3: Processor.searchContactByName(); break;
                    case 4: Processor.deleteContactById(); break;
                }
            }
        }
        System.out.println("Приложение закрыто.");
    }
}
