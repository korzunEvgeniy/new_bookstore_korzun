package com.korzun.bookstore.dao;

import com.korzun.bookstore.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(String isbn);

    List<Book> findByAuthor(String author);
}
