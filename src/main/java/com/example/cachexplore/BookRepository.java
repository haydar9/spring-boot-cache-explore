package com.example.cachexplore;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

//public interface BookRepository extends CrudRepository<Book, Long> {
public interface BookRepository extends JpaRepository<Book, Long> {
    @QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true")})
    Book findByIsbn(String isbn);

    @Override
    @QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<Book> findAllById(Iterable<Long> ids);
}