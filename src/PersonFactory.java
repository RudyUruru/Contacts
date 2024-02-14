import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonFactory {
    public static Person createPerson() throws IOException {
        System.out.println("\nСоздание нового контакта...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = new Person();

        System.out.print("Введите имя контакта: ");
        String name = reader.readLine();
        while (!Validator.isNameValid(name)) {
            System.out.print("Введите корректное имя: ");
            name = reader.readLine();
        }
        person.setName(name);

        System.out.print("(Необязательное поле) Введите фамилию контакта: ");
        String surname = reader.readLine();
        while (!Validator.isSurnameValid(surname)) {
            System.out.print("Введите корректную фамилию: ");
            surname = reader.readLine();
        }
        person.setSurname(surname);

        System.out.print("Введите номер телефона (например 9 876 543-22-11): ");
        String phoneNumber = reader.readLine();
        while (!Validator.isPhoneNumberValid(phoneNumber)) {
            System.out.print("Номер телефона не соответсвует формату, смотрите пример выше.\nВведите корректный номер телефона: ");
            phoneNumber = reader.readLine();
        }
        person.setPhoneNumber(phoneNumber);

        System.out.print("(Необязательное поле) Введите адрес электронной почты (например example@example.com): ");
        String email = reader.readLine();
        while (!Validator.isEmailValid(email)) {
            System.out.print("Почтовый адрес не соответсвует формату, смотрите пример выше.\nВведите корректную почту: ");
            email = reader.readLine();
        }
        person.setEmail(email);
        return person;
    }
}
