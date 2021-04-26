package com.shrkyash.shootership.gameinstance.factories;

import com.shrkyash.shootership.gameinstance.Config;
import com.shrkyash.shootership.gameinstance.models.GameStats;
import com.shrkyash.shootership.gameinstance.models.ShootingShipState;
import com.shrkyash.shootership.gameinstance.models.base.Direction;
import com.shrkyash.shootership.gameinstance.models.base.Ship;

import java.util.List;

public class ShootingShipStateFactory {
    private ShootingShipStateFactory() {
    }

    public static ShootingShipState getState(Config config) {
        Ship leftShip = new Ship(config.getPlayAreaXOrigin() + 1, config.getPlayAreaYOrigin() + 1, ">", 3, Direction.RIGHT);
        Ship rightShip = new Ship(config.getPlayAreaXBoundary() - 1, config.getPlayAreaYOrigin() + 1, "<", 3, Direction.LEFT);
        List<Ship> playingShips = List.of(leftShip, rightShip);
        GameStats stats = new GameStats(config.getStatsOriginX(), config.getStatsOriginY());
        return new ShootingShipState(playingShips, stats);
    }
}
