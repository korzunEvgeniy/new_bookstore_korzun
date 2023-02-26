package com.korzun.bookstore.dao.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "pages")
    private Integer pages;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "cover")
    private Cover cover;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "book")
    private List<OrderItem> items;

    @Column(name = "deleted")
    private boolean deleted;

    public Book(String isbn, String title, String author, Integer pages, Cover cover, BigDecimal price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.cover = cover;
        this.price = price;
    }

    public Book() {
    }

    public enum Cover {
        HARD,
        SOFT,
        GIFT
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return deleted == book.deleted
                && Objects.equals(id, book.id)
                && Objects.equals(isbn, book.isbn)
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && Objects.equals(pages, book.pages)
                && cover == book.cover
                && Objects.equals(price, book.price)
                && Objects.equals(items, book.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, author, pages, cover, price, items, deleted);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", cover=" + cover +
                ", price=" + price +
                ", items=" + items +
                ", deleted=" + deleted +
                '}';
    }
}
