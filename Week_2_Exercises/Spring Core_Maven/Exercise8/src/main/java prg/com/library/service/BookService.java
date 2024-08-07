package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    // Constructor for constructor injection
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter for setter injection
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Example service method
    public void someServiceMethod() {
        // Simulate some service logic
        System.out.println("Service method called");
        // Interact with the repository if needed
        bookRepository.performRepositoryTask();
    }

    // Additional service methods can be added here
}