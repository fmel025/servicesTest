package com.fmel025.tallerstudyng2.services;

import com.fmel025.tallerstudyng2.models.entities.Book;

import java.util.List;

public interface BookService {
    void save(Book book);
    void delete(String isbn);
    Book findOneById(String isbn);
    List<Book> findAll();
}
