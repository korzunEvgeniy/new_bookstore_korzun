package com.korzun.bookstore.service;

import com.korzun.bookstore.service.dto.OrderDto;
import com.korzun.bookstore.service.dto.UserDto;

import java.util.List;

public interface OrderService extends AbstractService<OrderDto, Long> {

    List<OrderDto> getOrdersByStatus(String status);

    List<OrderDto> getOrdersByUser(UserDto userDto);
}
