package com.first;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {

    // Find Book by Title
    List<Book> findByTitle(String title);

    // Find Book by Price
    List<Book> findByPrice(double price);

    // Find Book by Author
    List<Book> findByAuthor(String author);

}
