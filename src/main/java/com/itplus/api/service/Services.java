package com.itplus.api.service;

import java.util.List;
import java.util.Optional;

public interface Services<T> {
    public void delete(long id);
    public void save(T t);
    public void update(T t);
    public Optional<T> findById(long id);
    public List<T> findAll();
}
