package com.korzun.bookstore.rest;

import com .korzun.bookstore.service.BookService;
import com.korzun.bookstore.service.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public BookDto get(@PathVariable Long id) {
        return bookService.get(id);
    }

    @PostMapping
    public BookDto create(@RequestBody BookDto bookDto) {
        return bookService.create(bookDto);
    }

    @PutMapping
    public BookDto update(@RequestBody BookDto bookDto) {
        return bookService.update(bookDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping("/count")
    public Long countAll() {
        return bookService.countAll();
    }

    @GetMapping("/isbn/{isbn}")
    public BookDto getByIsbn(@PathVariable String isbn) {
        return bookService.getByIsbn(isbn);
    }

    @GetMapping("/author/{author}")
    public List<BookDto> getByAuthor(@PathVariable String author) {
        return bookService.getByAuthor(author);
    }
}
