public class Person {
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;

    public Person() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Validator.isEmailValid(email)) {
            this.email = email;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Validator.isNameValid(name)) {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (Validator.isSurnameValid(surname)) {
            this.surname = surname;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (Validator.isPhoneNumberValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
    }
}