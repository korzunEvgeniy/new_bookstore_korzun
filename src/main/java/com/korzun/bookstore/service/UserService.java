package com.korzun.bookstore.service;

import com.korzun.bookstore.service.dto.UserDto;

import java.util.List;

public interface UserService extends AbstractService<UserDto, Long> {

    List<UserDto> getByLastName(String lastName);

    UserDto getByEmail(String email);
}
