package com.shrkyash.shootership.gamerunner.repositories;

import com.shrkyash.shootership.gamerunner.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public void create(User user) {
        this.users.add(user);
    }

    public Optional<User> get(String id) {
        return this.users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
