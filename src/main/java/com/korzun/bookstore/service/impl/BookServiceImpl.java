package com.korzun.bookstore.service.impl;

import com.korzun.bookstore.service.BookService;
import com.korzun.bookstore.service.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public BookDto get(Long key) {
        return null;
    }

    @Override
    public List<BookDto> getAll() {
        return null;
    }

    @Override
    public BookDto create(BookDto entity) {
        return null;
    }

    @Override
    public BookDto update(BookDto entity) {
        return null;
    }

    @Override
    public void delete(Long key) {

    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public BookDto getByIsbn(String isbn) {
        return null;
    }

    @Override
    public List<BookDto> getByAuthor(String author) {
        return null;
    }
}
