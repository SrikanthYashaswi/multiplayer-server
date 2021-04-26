package com.shrkyash.shootership.gameinstance.models.base;

import com.shrkyash.shootership.gameinstance.models.UserInput;

import java.util.List;

public interface GameEnvironment {
    BaseFrame updateEnvironment(UserInput input);
    void registerPlayerIdentifiers(List<String> playerIds);
}
