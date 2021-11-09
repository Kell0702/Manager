package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book books = new Book();
    private TShirt shirt = new TShirt();
    private Book book1 = new Book(1, "Batmen", 100, "Гарднер Крэг Шоу", 360, 1963);
    private Book book2 = new Book(2, "Легион", 90, "Абнетт Дэн", 400, 1991);
    private TShirt shirt1 = new TShirt(3, "Чили", 50, "Черная", 50);
    private TShirt shirt2 = new TShirt(4, "Перец", 45, "Красная", 48);

    private void assertThrows() {
    }

    @Test
    public void shouldSaveOneItem() throws NotFoundException {
        repository.save(book1);

        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveTwoItems() throws NotFoundException {
        repository.save(book1);
        repository.save(shirt1);

        Product[] expected = new Product[]{book1, shirt1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemuveById() throws NotFoundException {
        repository.save(book1);
        repository.save(shirt1);
        int id = 0;
        try {
            repository.removeById(shirt1.getId());
        } catch (NotFoundException e) {
            assertThrows();
        }

        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundRemuveById() throws NotFoundException {
        repository.save(book1);
        repository.save(shirt1);
        int id = 2;
        try {
            repository.removeById(id);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertThrows();
        }

        Product[] expected = new Product[]{book1, shirt1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFoundRemuveById() throws NotFoundException {
        repository.save(book1);
        repository.save(shirt1);
        int id = 3;
        try {
            repository.removeById(id);
        } catch (NotFoundException e) {
            assertThrows();
        }

        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

}