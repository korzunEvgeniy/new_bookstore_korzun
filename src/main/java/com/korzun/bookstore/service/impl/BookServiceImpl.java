package com.korzun.bookstore.service.impl;

import com.korzun.bookstore.dao.BookRepository;
import com.korzun.bookstore.dao.entity.Book;
import com.korzun.bookstore.service.BookService;
import com.korzun.bookstore.service.dto.BookDto;
import com.korzun.bookstore.service.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto get(Long id) {
        Book book = bookRepository.findById(id).filter(b -> !b.isDeleted())
                .orElseThrow(() -> new RuntimeException("No book with id " + id));
        return bookMapper.mapToDto(book);
    }

    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .filter(book -> !book.isDeleted())
                .map(bookMapper::mapToDto)
                .toList();
    }

    @Override
    public BookDto create(BookDto bookDto) {
        Book existing = bookRepository.findByIsbn(bookDto.getIsbn());
        if (existing != null) {
            throw new RuntimeException("Book with ISBN " + bookDto.getIsbn() + " exist");
        } else
            return bookMapper.mapToDto(bookRepository.save(bookMapper.mapToEntity(bookDto)));
    }

    @Override
    public BookDto update(BookDto bookDto) {
        Book expected = bookRepository.findById(bookDto.getId()).filter(b -> !b.isDeleted())
                .orElseThrow(() -> new RuntimeException("No book with id " + bookDto.getId()));
        if (!Objects.equals(expected.getIsbn(), bookDto.getIsbn())) {
            throw new RuntimeException("Book with ISBN " + bookDto.getIsbn() + " is not exist");
        } else {
            return bookMapper.mapToDto(bookRepository.save(bookMapper.mapToEntity(bookDto)));
        }
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No book with id: " + id));
        if (!book.isDeleted()) {
            book.setDeleted(true);
            bookRepository.save(book);
        }
    }

    @Override
    public Long countAll() {
        return bookRepository.findAll()
                .stream()
                .filter(book -> !book.isDeleted())
                .count();
    }

    @Override
    public BookDto getByIsbn(String isbn) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> !book.isDeleted())
                .filter(book -> book.getIsbn().equals(isbn))
                .map(bookMapper::mapToDto)
                .findAny().orElseThrow(() -> new RuntimeException("No book with isbn " + isbn));
    }

    @Override
    public List<BookDto> getByAuthor(String author) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> !book.isDeleted())
                .filter(book -> book.getAuthor().equals(author))
                .map(bookMapper::mapToDto)
                .toList();
    }
}
