package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    private void assertThrows(int id) {
        System.out.println("Ошибка. Товара с таким ID-" + id + " не найдено.");
    }

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product[] findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return items;
            }
        }
        return null;
    }

    public void removeById(int id) throws NotFoundException {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
            if (findById(id) == null) {
//                throw new NotFoundException("Ошибка. Товара с таким ID-" + id + " не найдено.");

                assertThrows(id);
            }
        }
        items = tmp;
    }
}