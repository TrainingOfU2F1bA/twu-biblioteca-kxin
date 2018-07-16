package com.twu.biblioteca.repositories;

import java.util.List;

public interface Repository<T> {
    public List<T> list();
    public T find(Long id);
    public T findByName(String name);
    public void add();
    public void delete();
}
