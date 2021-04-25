package com.shrkyash.shootership.gamerunner.model;

import java.util.List;
import java.util.UUID;

public class MatchedPlayerGroup {
    public final String id;
    public final List<User> users;

    public MatchedPlayerGroup(List<User> users) {
        this.id = UUID.randomUUID().toString();
        this.users = users;
    }
}
