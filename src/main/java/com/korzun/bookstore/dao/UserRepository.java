package com.korzun.bookstore.dao;

import com.korzun.bookstore.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLastName(String lastName);

    User findByEmail(String email);
}
