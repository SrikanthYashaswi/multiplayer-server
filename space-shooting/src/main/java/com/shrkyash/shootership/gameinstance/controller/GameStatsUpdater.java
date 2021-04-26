package com.shrkyash.shootership.gameinstance.controller;

import com.shrkyash.shootership.gameinstance.models.ShootingShipState;
import com.shrkyash.shootership.gameinstance.models.base.Direction;

public class GameStatsUpdater extends Controller<ShootingShipState> {

    @Override
    public void update(ShootingShipState state) {
        var gameStats = state.getStats();
        final var leftShip = state
                .getPlayerShips()
                .stream()
                .filter(ship -> ship.getCannonDirection().equals(Direction.RIGHT))
                .findFirst();
        final var rightShip = state
                .getPlayerShips()
                .stream()
                .filter(ship -> ship.getCannonDirection().equals(Direction.LEFT))
                .findFirst();
        leftShip.ifPresent(ship -> gameStats.setLeftShipHealth(ship.getHealth()));
        rightShip.ifPresent(ship -> gameStats.setRightShipHealth(ship.getHealth()));
    }
}
