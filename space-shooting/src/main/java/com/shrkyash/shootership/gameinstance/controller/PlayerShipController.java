package com.shrkyash.shootership.gameinstance.controller;

import com.shrkyash.shootership.gameinstance.models.ShootingShipState;
import com.shrkyash.shootership.gameinstance.Config;
import com.shrkyash.shootership.gameinstance.models.PlayerShip;
import com.shrkyash.shootership.gameinstance.models.SimpleBullet;
import com.shrkyash.shootership.gameinstance.models.base.GameInput;

public class PlayerShipController extends Controller<ShootingShipState> {
    private final Config config;

    public PlayerShipController(Config config) {
        this.config = config;
    }
    @Override
    public void update(ShootingShipState state) {
        PlayerShip ship = state.getPlayerShip();
        GameInput input = state.getUserInput();
        switch (input) {
            case UP: {
                if (ship.getY() - 1 > config.getPlayAreaYOrigin()) {
                    ship.moveUp();
                }
                break;
            }
            case DOWN: {
                if (ship.getY() + 1 < config.getPlayAreaYBoundary()) {
                    ship.moveDown();
                }
                break;
            }
            case SHOOT: {
                state.addBullet(new SimpleBullet(ship.getX() + 1, ship.getY(), ship.getCannonDirection()));
                break;
            }
        }
    }
}
