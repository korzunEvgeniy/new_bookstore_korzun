package com.korzun.bookstore.rest;

import com.korzun.bookstore.service.UserService;
import com.korzun.bookstore.service.dto.UserDto;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> gerAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.get(id);
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/count")
    public Long count() {
        return userService.countAll();
    }

    @GetMapping("/lastName/{lastName}")
    public List<UserDto> getByLastName(@PathVariable String lastName) {
        return userService.getByLastName(lastName);
    }

    @GetMapping("/email/{email}")
    public UserDto getByemail(@PathVariable String email) {
        return userService.getByEmail(email);
    }
}
