package com.shrkyash.shootership.gamerunner.model;

import com.shrkyash.shootership.gameinstance.models.base.GameInput;

public class UserInput {

    private String id;
    private GameInput gameInput;

    public UserInput() {
    }

    public UserInput(String id, GameInput gameInput) {
        this.id = id;
        this.gameInput = gameInput;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GameInput getGameInput() {
        return gameInput;
    }

    public void setGameInput(GameInput gameInput) {
        this.gameInput = gameInput;
    }
}
