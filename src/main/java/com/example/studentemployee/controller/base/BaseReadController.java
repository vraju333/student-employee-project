package com.example.studentemployee.controller.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BaseReadController<T> {
    @GetMapping
    List<T> findAll();

    @GetMapping("/{id}")
    T findById(@PathVariable Long id);
}
