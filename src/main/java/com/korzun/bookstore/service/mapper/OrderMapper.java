package com.korzun.bookstore.service.mapper;

import com.korzun.bookstore.dao.OrderItemRepository;
import com.korzun.bookstore.dao.entity.Order;
import com.korzun.bookstore.dao.entity.OrderItem;
import com.korzun.bookstore.service.dto.OrderDto;
import com.korzun.bookstore.service.dto.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    private final OrderItemRepository orderItemRepository;
    private final BookMapper bookMapper;
    private final UserMapper userMapper;

    @Autowired
    public OrderMapper(OrderItemRepository orderItemRepository,
                       BookMapper bookMapper, UserMapper userMapper) {
        this.orderItemRepository = orderItemRepository;
        this.bookMapper = bookMapper;
        this.userMapper = userMapper;
    }

    public OrderDto mapToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setTotalCost(order.getTotalCost());
        orderDto.setTimestamp(order.getTimestamp());
        orderDto.setStatus(OrderDto.Status.valueOf(order.getStatus().toString()));
        orderDto.setUserDto(userMapper.mapToDto(order.getUser()));
        List<OrderItemDto> itemDtos = new ArrayList<>();
        List<OrderItem> items = orderItemRepository.findByOrderId(order.getId());
        for (OrderItem item : items) {
            itemDtos.add(mapToDto(order.getId(), item));
        }
        orderDto.setItems(itemDtos);
        return orderDto;
    }

    public Order mapToEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setTotalCost(orderDto.getTotalCost());
        order.setTimestamp(orderDto.getTimestamp());
        order.setStatus(Order.Status.valueOf(orderDto.getStatus().toString()));
        order.setUser(userMapper.mapToEntity(orderDto.getUserDto()));
        List<OrderItem> items = new ArrayList<>();
        List<OrderItemDto> itemDtos = orderDto.getItems();
        for (OrderItemDto itemDto : itemDtos) {
            OrderItem item = mapToEntity(orderDto.getId(), itemDto);
            items.add(item);
        }
        return order;
    }

    public OrderItemDto mapToDto(Long orderId, OrderItem item) {
        OrderItemDto itemDto = new OrderItemDto();
        itemDto.setId(item.getId());
        itemDto.setOrderId(orderId);
        itemDto.setBookDto(bookMapper.mapToDto(item.getBook()));
        itemDto.setQuantity(item.getQuantity());
        itemDto.setPrice(item.getPrice());
        return itemDto;
    }

    public OrderItem mapToEntity(Long orderId, OrderItemDto itemDto) {
        OrderItem item = new OrderItem();
        item.setId(itemDto.getId());
        item.setOrderId(orderId);
        item.setBook(bookMapper.mapToEntity(itemDto.getBookDto()));
        item.setQuantity(itemDto.getQuantity());
        item.setPrice(itemDto.getPrice());
        return item;
    }
}
