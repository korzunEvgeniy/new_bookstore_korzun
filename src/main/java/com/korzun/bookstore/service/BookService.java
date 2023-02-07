package com.korzun.bookstore.service;

import com.korzun.bookstore.service.dto.BookDto;

import java.util.List;

public interface BookService extends AbstractService<BookDto, Long> {

    BookDto getByIsbn(String isbn);

    List<BookDto> getByAuthor(String author);
}
