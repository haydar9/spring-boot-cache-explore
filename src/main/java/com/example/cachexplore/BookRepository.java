package com.example.cachexplore;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    @QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true")})
    Book findByIsbn(String isbn);

}

//Potato