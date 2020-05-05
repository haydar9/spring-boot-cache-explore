package com.example.cachexplore;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

//public interface BookRepository extends CrudRepository<Book, Long> {
public interface BookRepository extends JpaRepository<Book, Long> {
    //@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true")})
    @Cacheable(value="com.example.cachexplore.Book", key="#isbn")
    Book findByIsbn(String isbn);

    @Override
    //@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true")})
    @Cacheable(value="com.example.cachexplore.Book")
    List<Book> findAllById(Iterable<Long> ids);
}