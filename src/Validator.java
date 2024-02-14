import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_-]+(?:\\.[a-zA-Z0-9_-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    private static final String PHONE_NUMBER_REGEX = "^\\d{1} \\d{3} \\d{3}-\\d{2}-\\d{2}$";
    private static final Pattern phonePattern = Pattern.compile(PHONE_NUMBER_REGEX);

    private static final String NAME_REGEX = "^[a-zA-Zа-яА-Я]+$";
    private static final Pattern namePattern = Pattern.compile(NAME_REGEX);
    private static final int ACTION_NUMBER_MAX_VALUE = 5;
    private static final int ACTION_NUMBER_MIN_VALUE = 1;
    public static boolean isActionNumberValid(int actionNumber) {
        if (actionNumber < ACTION_NUMBER_MIN_VALUE || actionNumber > ACTION_NUMBER_MAX_VALUE) {
            System.out.println("Номер действия должен быть между " + ACTION_NUMBER_MIN_VALUE + " и " + ACTION_NUMBER_MAX_VALUE);
            return false;
        } else {
            return true;
        }
    }

    public static boolean isNameValid(String name) {

        if (name == null) {
            System.out.println("Нельзя передавать null!");
            return false;
        }

        Matcher nameMatcher = namePattern.matcher(name);
        if (nameMatcher.matches()) {
            return nameMatcher.matches();
        } else {
            System.out.println("Имя не может быть пустым, содержать специальных символов и цифр или состоять из пробелов.");
            return false;
        }
    }

    public static boolean isSurnameValid(String surname) {

        if (surname == null) {
            System.out.println("Нельзя передавать null!");
            return false;
        }

        if (surname.isEmpty()) {
            return true;
        }

        Matcher surnameMatcher = namePattern.matcher(surname);
        if (surnameMatcher.matches()) {
            return surnameMatcher.matches();
        } else {
            System.out.println("Фамилия не может содержать специальных символов и цифр или состоять из пробелов.");
            return false;
        }
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {

        if (phoneNumber == null) {
            System.out.println("Нельзя передавать null!");
            return false;
        }

        Matcher phoneMatcher = phonePattern.matcher(phoneNumber);
        return phoneMatcher.matches();
    }

    public static boolean isEmailValid(String email) {

        if (email == null) {
            System.out.println("Нельзя передавать null!");
            return false;
        }

        if (email.isEmpty()) {
            return true;
        }

        Matcher emailMatcher = emailPattern.matcher(email);
        return emailMatcher.matches();
    }
}
