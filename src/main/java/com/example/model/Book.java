package com.example.model;

/**
 * @author hellscorpion
 * @date 2017-04-23
 * @version 1.0
 */
public class Book {

    private ISBN isbn;
    private String name;

    public Book(ISBN isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }

    /**
     * @return the isbn
     */
    public ISBN getIsbn() {
        return isbn;
    }

    /**
     * @param isbn
     *            the isbn to set
     */
    public void setIsbn(ISBN isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
