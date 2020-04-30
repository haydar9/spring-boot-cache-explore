package com.example.cachexplore;

public interface BookRepository {

  Book getByIsbn(String isbn);

}