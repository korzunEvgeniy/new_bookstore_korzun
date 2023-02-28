package com.korzun.bookstore.service.impl;

import com.korzun.bookstore.service.UserService;
import com.korzun.bookstore.service.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDto get(Long key) {
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public UserDto create(UserDto entity) {
        return null;
    }

    @Override
    public UserDto update(UserDto entity) {
        return null;
    }

    @Override
    public void delete(Long key) {

    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<UserDto> getByLastName(String lastName) {
        return null;
    }

    @Override
    public UserDto getByEmail(String email) {
        return null;
    }
}
