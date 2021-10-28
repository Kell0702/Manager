package ru.netology.repository;

public class NotFoundException extends Throwable {

    public NotFoundException(String s) {
        super(s);
    }
}
