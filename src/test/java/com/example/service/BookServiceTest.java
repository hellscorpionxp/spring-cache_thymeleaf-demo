package com.example.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Book;
import com.example.model.ISBN;

/**
 * @author hellscorpion
 * @date 2017-04-25
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath*:/spring-cache.xml")
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    /**
     * Test method for
     * {@link com.example.service.BookService#saveBook(com.example.model.ISBN, java.lang.String)}.
     */
    @Test
    public void testSaveBook() {
        ISBN isbn = new ISBN("123456");
        Book book = new Book(isbn, "xxx");
        bookService.saveBook(book);
        book.setName("yyy");
        bookService.saveBook(book);
        Book book1 = bookService.getBook(isbn);
        assertEquals("xxx", book1.getName());
    }

    /**
     * Test method for
     * {@link com.example.service.BookService#deleteBook(com.example.model.ISBN)}.
     */
    @Test
    public void testDeleteBook() {
        bookService.deleteBook(new ISBN("123456"));
    }

    /**
     * Test method for
     * {@link com.example.service.BookService#getBook(com.example.model.ISBN)}.
     */
    @Test
    public void testGetBook() {
        bookService.getBook(new ISBN("123456"));
    }

}
