package Functions;

import Common.Print;

public class TestAuthor {


    public void main() {
        Author a1 = new Author("Adam Mickiewicz 66");
        Author a2 = new Author("Bolesław Leśmian 55");
        Author a3 = new Author("Bolesław Prus 55");
        Author a4 = new Author("Eliza Orzeszkowa 34");

        Print.println("author firstname: " + a1.getFirstname() + " surname: " + a1.getSurname() + ", age = " + a1.getAge());
        Print.println("author firstname: " + a2.getFirstname() + " surname: " + a2.getSurname() + ", age = " + a2.getAge());
        Print.println("author firstname: " + a3.getFirstname() + " surname: " + a3.getSurname() + ", age = " + a3.getAge());
        Print.println("author firstname: " + a4.getFirstname() + " surname: " + a4.getSurname() + ", age = " + a4.getAge());

    }
}