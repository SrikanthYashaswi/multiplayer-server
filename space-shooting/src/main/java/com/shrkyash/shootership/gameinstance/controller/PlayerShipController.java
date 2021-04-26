package com.shrkyash.shootership.gameinstance.controller;

import com.shrkyash.shootership.gameinstance.Config;
import com.shrkyash.shootership.gameinstance.models.ShootingShipState;
import com.shrkyash.shootership.gameinstance.models.SimpleBullet;

public class PlayerShipController extends Controller<ShootingShipState> {
    private final Config config;

    public PlayerShipController(Config config) {
        this.config = config;
    }

    @Override
    public void update(ShootingShipState state) {
        final var userInput = state.getUserInput();
        final var updatedShip = state
                .getPlayerShips()
                .stream()
                .filter(ship -> ship.getPlayerId().equals(userInput.getId()))
                .findFirst();
        if (updatedShip.isEmpty()) {
            return;
        }
        switch (userInput.getGameInput()) {
            case UP: {
                if (updatedShip.get().getY() - 1 > config.getPlayAreaYOrigin()) {
                    updatedShip.get().moveUp();
                }
                break;
            }
            case DOWN: {
                if (updatedShip.get().getY() + 1 < config.getPlayAreaYBoundary()) {
                    updatedShip.get().moveDown();
                }
                break;
            }
            case SHOOT: {
                state.addBullet(new SimpleBullet(updatedShip.get().getX() + 1, updatedShip.get().getY(), updatedShip.get().getCannonDirection()));
                break;
            }
        }
    }
}
