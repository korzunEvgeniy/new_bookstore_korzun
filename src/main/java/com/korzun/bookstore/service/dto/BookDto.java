package com.korzun.bookstore.service.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class BookDto {

    private Long id;
    private String isbn;
    private String title;
    private String author;
    private Integer pages;
    private Cover cover;
    private BigDecimal price;

    public BookDto(String isbn, String title, String author, Integer pages, Cover cover, BigDecimal price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.cover = cover;
        this.price = price;
    }

    public BookDto() {
    }

    public enum Cover {
        HARD,
        SOFT,
        GIFT
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPages() {
        return pages;
    }

    public Cover getCover() {
        return cover;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(id, bookDto.id)
                && Objects.equals(isbn, bookDto.isbn)
                && Objects.equals(title, bookDto.title)
                && Objects.equals(author, bookDto.author)
                && Objects.equals(pages, bookDto.pages)
                && Objects.equals(cover, bookDto.cover)
                && Objects.equals(price, bookDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, author, pages, cover, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", cover='" + cover + '\'' +
                ", price=" + price +
                '}';
    }
}
