package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve beans to verify they are correctly configured
        BookService bookService = context.getBean(BookService.class);

        // Print to verify the bean
        System.out.println("BookService bean: " + bookService);
    }
}