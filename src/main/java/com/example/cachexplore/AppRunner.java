package com.example.cachexplore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.sf.ehcache.CacheManager;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book("isbn-1234", "some book");
        bookRepository.save(book);
        bookRepository.findByIsbn("isbn-1234");
        bookRepository.findByIsbn("isbn-1234");
        int size = CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("com.example.cachexplore.Book").getSize();
        logger.info("Size: " + size);
    }

}