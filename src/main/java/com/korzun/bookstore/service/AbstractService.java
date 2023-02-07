package com.korzun.bookstore.service;

import java.util.List;

public interface AbstractService<T, K> {

    T get (K key);

    List<T> getAll();

    T create(T entity);

    T update(T entity);

    void delete(K key);

    K countAll();
}
