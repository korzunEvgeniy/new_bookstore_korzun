package com.korzun.bookstore.dao;

import com.korzun.bookstore.dao.entity.Order;
import com.korzun.bookstore.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);
}
