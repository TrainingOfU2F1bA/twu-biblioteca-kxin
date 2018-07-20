package com.twu.biblioteca.repositories;

import com.twu.biblioteca.model.Customer;
import com.twu.biblioteca.model.User;

import java.util.Arrays;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    List<User> arrayList = Arrays.asList(
            new Customer(1l,"Tom","010-8888",18,"123","9999882","123@.com"),
            new Customer(2l,"Marry","010-9999",16,"123","9999882","123@.com"),
            new Customer(3l,"Jack","010-6666",19,"123","9999882","123@.com")
    );

    @Override
    public List<User> list() {
        return arrayList;
    }

    @Override
    public User find(Long id) {
        for (User user : arrayList) if (user.getId().equals(id)) return user;
        return null;
    }

    @Override
    public User findByName(String name) {
        for (User user : arrayList) if (user.getUserName().equals(name)) return user;
        return null;
    }

    @Override
    public void add(User user) {
        arrayList.add(user);
    }

    @Override
    public void delete(Long id) {
        arrayList.removeIf(user -> user.getId().equals(id));
    }
}
