package com.korzun.bookstore.service.dto;

import java.util.Objects;

public class UserDto {

    private Long id;
    private String lastName;
    private String email;
    private String password;
    private Role role;

    public UserDto(String lastName, String email, String password, Role role) {
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserDto() {
    }

    public enum Role {
        ADMIN,
        MANAGER,
        CUSTOMER
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id)
                && Objects.equals(lastName, userDto.lastName)
                && Objects.equals(email, userDto.email)
                && Objects.equals(password, userDto.password)
                && role == userDto.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, email, password, role);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
