package com.korzun.bookstore.dao;

import com.korzun.bookstore.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
