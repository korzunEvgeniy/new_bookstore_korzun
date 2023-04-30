package com.korzun.bookstore.service.impl;

import com.korzun.bookstore.dao.OrderRepository;
import com.korzun.bookstore.dao.entity.Order;
import com.korzun.bookstore.service.OrderService;
import com.korzun.bookstore.service.dto.OrderDto;
import com.korzun.bookstore.service.dto.UserDto;
import com.korzun.bookstore.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDto get(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No order with id " + id));
        return orderMapper.mapToDto(order);
    }

    @Override
    public List<OrderDto> getAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::mapToDto)
                .toList();
    }

    @Override
    public List<OrderDto> getOrdersByStatus(String status) {
        return orderRepository.findAll()
                .stream()
                .filter(o -> o.getStatus().equals(Order.Status.valueOf(status)))
                .map(orderMapper::mapToDto)
                .toList();
    }

    @Override
    public OrderDto create(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No order with id " + id));
        String status = order.getStatus().toString();
        if (status.equals("CANCELLED")) {
            order.setStatus(Order.Status.CANCELLED);
        }
        orderRepository.save(order);
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<OrderDto> getOrdersByUser(UserDto userDto) {
        return null;
    }
}
