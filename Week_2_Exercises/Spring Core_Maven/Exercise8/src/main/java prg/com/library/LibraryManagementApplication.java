package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookService = context.getBean(BookService.class);

        // Call a method on the BookService to trigger the aspect
        // Example method call (you should have actual methods in BookService)
        bookService.someServiceMethod();  // Replace with actual method name

        // Print to verify that the aspect is working
        System.out.println("BookService bean: " + bookService);
    }
}