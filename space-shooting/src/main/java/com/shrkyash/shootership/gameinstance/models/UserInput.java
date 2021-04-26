package com.shrkyash.shootership.gameinstance.models;

import com.shrkyash.shootership.gameinstance.models.base.GameInput;

public class UserInput {

    private String id;
    private GameInput userInput;

    public UserInput() {
    }

    public UserInput(String id, GameInput userInput) {
        this.id = id;
        this.userInput = userInput;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GameInput getGameInput() {
        return userInput;
    }

    public void setGameInput(GameInput userInput) {
        this.userInput = userInput;
    }
}
