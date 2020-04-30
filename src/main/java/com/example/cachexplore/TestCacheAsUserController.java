package com.example.cachexplore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.sf.ehcache.CacheManager;

@RestController
public class TestCacheAsUserController {

    private static final Logger logger = LoggerFactory.getLogger(TestCacheAsUserController.class);

    private BookRepository bookRepository;

    public TestCacheAsUserController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book/findByIsbn/{isbn}")
    public void getByISBN(@PathVariable String isbn) {
        bookRepository.findByIsbn(isbn);
        int size = CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("com.example.cachexplore.Book").getSize();
        logger.info("Book entity cache Size: " + size);
    }

    @GetMapping("/book/{id}")
    public void getById(@PathVariable long id) {
        bookRepository.findById(id);
        int size = CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("com.example.cachexplore.Book").getSize();
        logger.info("Book entity cache Size: " + size);
    }
}