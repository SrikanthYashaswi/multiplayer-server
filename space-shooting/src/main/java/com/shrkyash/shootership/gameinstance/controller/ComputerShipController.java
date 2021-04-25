package com.shrkyash.shootership.gameinstance.controller;

import com.shrkyash.shootership.gameinstance.Config;
import com.shrkyash.shootership.gameinstance.models.ShootingShipState;
import com.shrkyash.shootership.gameinstance.models.SimpleBullet;
import com.shrkyash.shootership.gameinstance.models.base.Direction;

import java.util.Random;

public class ComputerShipController extends Controller<ShootingShipState> {
    private final Random rand = new Random();
    protected final Config config;
    private int counter = 0;
    private Direction movingDirection = Direction.DOWN;

    public ComputerShipController(Config config) {
        this.config = config;
    }

    private boolean shouldFireBullet() {
        return rand.nextInt(5) == 0;
    }

    private void moveShip(ShootingShipState state) {
        if (state.getComputerShip().getY() > config.getPlayAreaYBoundary() - 2) {
            movingDirection = Direction.UP;
        }
        if (state.getComputerShip().getY() < config.getPlayAreaYOrigin() + 2) {
            movingDirection = Direction.DOWN;
        }
        state.getComputerShip().move(movingDirection);
    }

    @Override
    public void update(ShootingShipState state) {
        if ((counter = (counter + 1) % config.getComputerShipMovementDelay()) != 0) {
            return;
        }
        if (shouldFireBullet()) {
            state.addBullet(new SimpleBullet(state.getComputerShip().getX(), state.getComputerShip().getY(),
                    state.getComputerShip().getCannonDirection()));
        }
        moveShip(state);
    }
}
