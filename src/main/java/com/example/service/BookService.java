package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.model.ISBN;

import net.sf.ehcache.Ehcache;

/**
 * @author hellscorpion
 * @date 2017-04-25
 * @version 1.0
 */
@Service
public class BookService {

    private static final Map<String, Book> BOOK_MAP = new HashMap<>();
    @Autowired
    private CacheManager cacheManager;

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
        System.out.println("##### cache is missing #####");
        return BOOK_MAP.get(isbn.getCode());
    }

    public List<Book> getBooks(String name) {
        List<Book> books = new ArrayList<>();
        Ehcache ehcache = (Ehcache) cacheManager.getCache(name)
            .getNativeCache();
        for (Object key : ehcache.getKeys()) {
            books.add((Book) ehcache.get(key).getObjectValue());
        }
        return books;
    }

}
