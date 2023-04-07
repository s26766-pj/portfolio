package Functions;

public class Author {
    private final String firstname;
    private final String surname;
    private final int age;

    public Author(String data) {
        String[] data_arr = data.split(" ");
        this.firstname = data_arr[0];
        this.surname = data_arr[1];
        this.age = Integer.parseInt(data_arr[2]);
    }
    public String getFirstname() {
        return firstname;
    }
    public String getSurname() {
        return surname;
    }
    public String getAge() {
        return String.valueOf(age);
    }
    public String getName() {
        return getFirstname() + " " + getSurname();
    }
    public String toString() {
        return getName() + " " + getAge();
    }
}