public class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws InvalidAgeException {
        this.name = name;
        setAge(age);
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Wiek nie może być ujemny.");
        }
        if (age > 100) {
            throw new InvalidAgeException("Wiek nie może być większy od 100.");
        }
        this.age = age;
    }
    @Override
    public String toString() {
        return name;
    }

}
