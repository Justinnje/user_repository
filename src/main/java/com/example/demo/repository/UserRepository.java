package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<>();

    private long nextId;

    private UserRepository() {
        userList.add(new User(1L, "Justin", "justin.ng@gmail.com"));
        userList.add(new User(2L, "Charlie", "charlie@yahoo.com"));
        nextId = userList.size();
    }

    public List<User> findAll() {
        return userList;
    }

    public Optional<User> findById(Long id) {
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User addUser(User user) {
        nextId++;
        user.setId(nextId);
        userList.add(user);
        return user;
    }




}
