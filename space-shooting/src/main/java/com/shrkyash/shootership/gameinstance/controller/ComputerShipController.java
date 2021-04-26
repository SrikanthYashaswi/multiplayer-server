package com.shrkyash.shootership.gameinstance.controller;

import com.shrkyash.shootership.gameinstance.Config;
import com.shrkyash.shootership.gameinstance.models.UserInput;
import com.shrkyash.shootership.gameinstance.models.base.GameInput;

import java.util.Random;

public class ComputerShipController {

    private String computerId;
    private final Random rand = new Random();
    protected final Config config;
    private int x, y;

    public ComputerShipController(Config config) {
        this.config = config;
    }

    private boolean shouldFireBullet() {
        return rand.nextInt(5) == 0;
    }

    public UserInput nextInput() {
        return new UserInput(computerId, GameInput.UNDEFINED);
    }

    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }
}
