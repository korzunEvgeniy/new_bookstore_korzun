package com.korzun.bookstore.service.mapper;

import com.korzun.bookstore.dao.entity.Book;
import com.korzun.bookstore.service.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDto mapToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getTitle());
        bookDto.setPages(book.getPages());
        bookDto.setCover(BookDto.Cover.valueOf(book.getCover().toString()));
        bookDto.setPrice(book.getPrice());
        return bookDto;
    }

    public Book mapToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPages(bookDto.getPages());
        book.setCover(Book.Cover.valueOf(bookDto.getCover().toString()));
        book.setPrice(bookDto.getPrice());
        return book;
    }
}
