package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Book books = new Book();
    private TShirt shirt = new TShirt();
    private Book book1 = new Book(1, "Batmen", 100, "Гарднер Крэг Шоу", 360, 1963);
    private Book book2 = new Book(2, "Легион", 90, "Абнетт Дэн", 400, 1991);
    private TShirt shirt1 = new TShirt(3, "Чили", 50, "Черная", 50);
    private TShirt shirt2 = new TShirt(4, "Перец", 45, "Красная", 48);

//    @Test
//    public void shouldUseEquals() {
//        Product first = new Product(1, "Java I", 1000);
//        Product second = new Product(1, "Java I", 1000);
//        assertEquals(first, second);
//    }

    @Test
    public void shouldEquals() {
        Product first = book1;
        Product product = (book1);

        Product expected = first;
        Product actual= first;
        assertEquals(expected, actual);
    }
}