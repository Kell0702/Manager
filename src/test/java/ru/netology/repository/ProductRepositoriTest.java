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

    @Test
    public void shouldSaveOneItem() {
        repository.save(book1);

        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveTwoItems() {
        repository.save(book1);
        repository.save(shirt1);

        Product[] expected = new Product[]{book1, shirt1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemuveById() {
        repository.save(book1);
        repository.save(shirt1);
        try {
            repository.removeById(shirt1.getId());
        }catch (NotFoundException e){
            System.out.println("Ошибка. Товара с таким ID не найдено.");
        }

        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundRemuveById() {
        repository.save(book1);
        repository.save(shirt1);
        int id = 2;
        try {
            repository.removeById(id);
        }catch (NotFoundException e){
            System.out.println("Ошибка. Товара с таким ID-"+id+" не найдено.");
        }

        Product[] expected = new Product[]{book1,shirt1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldFindById() {
//        repository.save(book1);
//        repository.save(book2);
//        repository.save(shirt1);
//        repository.save(shirt2);
//        repository.removeById(shirt1.getId());
//
//        Product[] expected = new Product[]{book1, book2, shirt2};
//        Product[] actual = repository.findAll();
//        assertArrayEquals(expected, actual);
//    }
}