package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary ");
        System.out.println("___________________________________________________________");
    }


    public String returnBook() {
        int a = 10/0;
        System.out.println("Мы возращаем книгу в UniLibrary");
        return "Война и мир";
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал из UniLibrary ");
        System.out.println("___________________________________________________________");

    }

    public void returnMagazine() {
        System.out.println("Мы возращаем журнал в UniLibrary ");
        System.out.println("___________________________________________________________");

    }

    public void addBook(String person_name, Book book) {
        System.out.println("Мы добавляем книгу в UniLibrary ");
        System.out.println("___________________________________________________________");

    }

    public void addMagazine() {
        System.out.println("Мы добавляем журнал в UniLibrary ");
        System.out.println("___________________________________________________________");

    }

}