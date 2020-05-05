package com.example.cachexplore;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames={"books"})
//public interface BookRepository extends CrudRepository<Book, Long> {
public interface BookRepository extends JpaRepository<Book, Long> {
    
    //@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true")})
    
    @Cacheable(key="")
    //TODO: perhaps we need to plugin in ehcahce or use JCache annotations and plug into same cache provider that hibernate uses 
    // @Caching(
    //   put = {
    //         @CachePut(value = "books", key = "#result.isbn", condition = "#result != null"),
    //         @CachePut(value = "books", key = "#result.id", condition = "#result != null")
    //   }
	// )
    List<Book> findByIsbn(String isbn);

    @Override
    @Cacheable
    List<Book> findAllById(Iterable<Long> ids);
}