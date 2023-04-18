package com.korzun.bookstore.service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class OrderDto {

    private Long id;
    private UserDto userDto;
    private BigDecimal totalCost;
    private List<OrderItemDto> items;
    private LocalDateTime timestamp;
    private Status status;

    public enum Status {
        PENDING_PAYMENT,
        PAID,
        CANCELLED
    }

    public OrderDto(Long id, UserDto userDto, BigDecimal totalCost, List<OrderItemDto> items, LocalDateTime timestamp, Status status) {
        this.id = id;
        this.userDto = userDto;
        this.totalCost = totalCost;
        this.items = items;
        this.timestamp = timestamp;
        this.status = status;
    }

    public OrderDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(id, orderDto.id) && Objects.equals(userDto, orderDto.userDto) && Objects.equals(totalCost, orderDto.totalCost) && Objects.equals(items, orderDto.items) && Objects.equals(timestamp, orderDto.timestamp) && status == orderDto.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userDto, totalCost, items, timestamp, status);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", userDto=" + userDto +
                ", totalCost=" + totalCost +
                ", items=" + items +
                ", timestamp=" + timestamp +
                ", status=" + status +
                '}';
    }
}
