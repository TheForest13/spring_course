package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Преступление и наказание")
    private String name;

    @Value("Ф.М. Достоевкий")
    private String author;

    @Value("1866")
    private int yearPublication;

    public String getAuthor() {
        return author;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public String getName() {
        return name;
    }
}
