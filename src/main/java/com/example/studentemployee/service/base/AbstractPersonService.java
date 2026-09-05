package com.example.studentemployee.service.base;

import java.util.List;

public abstract class AbstractPersonService<T, R> {
    public abstract T create(R request);
    public abstract T getById(Long id);
    public abstract List<T> getAll();
    public abstract T update(Long id, R request);
    public abstract void delete(Long id);

    protected String normalize(String value) {
        return value == null ? null : value.trim();
    }
}
