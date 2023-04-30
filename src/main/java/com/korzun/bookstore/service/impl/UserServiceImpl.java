package com.korzun.bookstore.service.impl;

import com.korzun.bookstore.dao.UserRepository;
import com.korzun.bookstore.dao.entity.User;
import com.korzun.bookstore.service.UserService;
import com.korzun.bookstore.service.dto.UserDto;
import com.korzun.bookstore.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto get(Long id) {
        User user = userRepository.findById(id)
                .filter(u -> !u.isDeleted())
                .orElseThrow(() -> new RuntimeException("No user with id " + id));
        return userMapper.mapToDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .filter(u -> !u.isDeleted())
                .map(userMapper::mapToDto)
                .toList();
    }

    @Override
    public UserDto create(UserDto userDto) {
        User existing = userRepository.findByEmail(userDto.getEmail());
        if (existing != null) {
            throw new RuntimeException("User with email " + userDto.getEmail() + " exist");
        }
        else {
            return userMapper.mapToDto(userRepository.save(userMapper.mapToEntity(userDto)));
        }
    }

    @Override
    public UserDto update(UserDto userDto) {
        User expected = userRepository.findById(userDto.getId()).filter(u -> !u.isDeleted())
                .orElseThrow(() -> new RuntimeException("No user with id " + userDto.getId()));
        if (!Objects.equals(expected.getEmail(), userDto.getEmail())) {
            throw new RuntimeException("User with email " + userDto.getEmail() + " is not exist");
        } else {
            return userMapper.mapToDto(userRepository.save(userMapper.mapToEntity(userDto)));
        }
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No user with id " + id));
        if (!user.isDeleted()) {
            user.setDeleted(true);
            userRepository.save(user);
        }
    }

    @Override
    public Long countAll() {
        return userRepository.findAll()
                .stream()
                .filter(u -> !u.isDeleted())
                .count();
    }

    @Override
    public List<UserDto> getByLastName(String lastName) {
        return userRepository.findAll()
                .stream()
                .filter(u -> !u.isDeleted())
                .filter(u -> u.getLastName().equals(lastName))
                .map(userMapper::mapToDto)
                .toList();
    }

    @Override
    public UserDto getByEmail(String email) {
        return userRepository.findAll()
                .stream()
                .filter(u -> !u.isDeleted())
                .filter(u -> u.getEmail().equals(email))
                .map(userMapper::mapToDto)
                .findAny().orElseThrow(() -> new RuntimeException("No user with email " + email));
    }
}
