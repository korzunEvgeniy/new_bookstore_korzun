package com.korzun.bookstore.service.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderItemDto {

    private Long id;
    private Long orderId;
    private BookDto bookDto;
    private Integer quantity;
    private BigDecimal price;

    public OrderItemDto(Long id, Long orderId, BookDto bookDto, Integer quantity, BigDecimal price) {
        this.id = id;
        this.orderId = orderId;
        this.bookDto = bookDto;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemDto that = (OrderItemDto) o;
        return Objects.equals(id, that.id) && Objects.equals(orderId, that.orderId) && Objects.equals(bookDto, that.bookDto) && Objects.equals(quantity, that.quantity) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, bookDto, quantity, price);
    }

    @Override
    public String toString() {
        return "OrderItemDto{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", bookDto=" + bookDto +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
