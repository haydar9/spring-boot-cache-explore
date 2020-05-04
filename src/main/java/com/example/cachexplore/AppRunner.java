package com.example.cachexplore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    private EntityManager entityManager;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("isbn-" + i, "some book");
            // books.add(book);
            bookRepository.save(book);
        }
        
        logger.info("find 1,2,3,4,5 (try 1)");
        findAllQuery(Arrays.asList(1l, 2l, 3l, 4l, 5l));
        logger.info("find 1,2,3,4,5 (try 2)");
        findAllQuery(Arrays.asList(1l, 2l, 3l, 4l, 5l));
    }

    public List<Book> findAllQuery(List<Long> ids) {
        Query q = entityManager.createQuery("SELECT b FROM Book b WHERE b.id in :ids").setParameter("ids", ids).setHint("org.hibernate.cacheable", true);
        return q.getResultList();
    }

}