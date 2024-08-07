package com.example.library;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for bookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Other methods related to BookService
    public void performService() {
        // Use bookRepository to perform operations
        System.out.println("Performing service with book repository");
    }
}