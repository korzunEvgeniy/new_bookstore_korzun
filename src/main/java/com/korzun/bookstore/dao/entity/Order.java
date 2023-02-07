package com.korzun.bookstore.dao.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @OneToMany
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<OrderItem> items;

    public Order(User user, BigDecimal totalCost, LocalDateTime timestamp, Status status) {
        this.user = user;
        this.totalCost = totalCost;
        this.timestamp = timestamp;
        this.status = status;
    }

    public Order() {
    }

    public enum Status {
        PENDING_PAYMENT,
        PAID,
        CANCELLED

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
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

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id)
                && Objects.equals(user, order.user)
                && Objects.equals(totalCost, order.totalCost)
                && Objects.equals(timestamp, order.timestamp)
                && status == order.status
                && Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, totalCost, timestamp, status, items);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", totalCost=" + totalCost +
                ", timestamp=" + timestamp +
                ", status=" + status +
                ", items=" + items +
                '}';
    }
}
