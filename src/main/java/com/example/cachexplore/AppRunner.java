package com.example.cachexplore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    @Autowired
    private EntityManager EntityManager;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        setUpTestSaveSomeBooks();

        //testFindById();

        testFindAllById();

        testQueryCache();

    }

    private void testFindById() {
        logger.info("find ID 10 (try 1)");
        bookRepository.findById(10l);
        logger.info("find ID 10 (try 2)");
        bookRepository.findById(10l);
    }

    private void setUpTestSaveSomeBooks() {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("isbn-" + i, "some book");
            books.add(book);
        }
        bookRepository.saveAll(books);
    }

    private void testQueryCache() {
         logger.info("find by isbn 1234 (try 1)");
        bookRepository.findByIsbn("isbn-1234");
        logger.info("find by isbn 1234 (try 2)");
        bookRepository.findByIsbn("isbn-1234");
    }

    private void testFindAllById() {
        logger.info("find 1,2,3,4,5 (try 1)");
        bookRepository.findAllById(Arrays.asList(1l, 2l, 3l, 4l, 5l));
        logger.info("find 1,2,3,4,5 (try 2)");
        bookRepository.findAllById(Arrays.asList(1l, 2l, 3l, 4l, 5l));

        logger.info("find 1,2,3,4,5,6,7 (try 1)");
        bookRepository.findAllById(Arrays.asList(1l, 2l, 3l, 4l, 5l, 6l, 7l));
    }
}