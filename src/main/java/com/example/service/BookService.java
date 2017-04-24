package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.model.ISBN;

/**
 * @author hellscorpion
 * @date 2017-04-25
 * @version 1.0
 */
@Service
public class BookService {

    private static final Map<String, Book> BOOK_MAP = new HashMap<>();

    @CachePut(cacheNames = "books", key = "#book.isbn.code")
    public Book saveBook(Book book) {
        BOOK_MAP.put(book.getIsbn().getCode(), book);
        return book;
    }

    @CacheEvict(cacheNames = "books", key = "#isbn.code")
    public Book deleteBook(ISBN isbn) {
        return BOOK_MAP.remove(isbn.getCode());
    }

    @Cacheable(cacheNames = "books", key = "#isbn.code")
    public Book getBook(ISBN isbn) {
        return BOOK_MAP.get(isbn.getCode());
    }

}
