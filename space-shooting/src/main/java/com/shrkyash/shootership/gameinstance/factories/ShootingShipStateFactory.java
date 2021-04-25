package com.shrkyash.shootership.gameinstance.factories;

import com.shrkyash.shootership.gameinstance.models.ShootingShipState;
import com.shrkyash.shootership.gameinstance.Config;
import com.shrkyash.shootership.gameinstance.models.ComputerShip;
import com.shrkyash.shootership.gameinstance.models.GameStats;
import com.shrkyash.shootership.gameinstance.models.PlayerShip;

public class ShootingShipStateFactory {
    private ShootingShipStateFactory() {
    }

    public static ShootingShipState getState(Config config) {
        PlayerShip playerShip = new PlayerShip(config.getPlayAreaXOrigin() + 1, config.getPlayAreaYOrigin() + 1);
        ComputerShip computerShip = new ComputerShip(config.getPlayAreaXBoundary() - 1, config.getPlayAreaYOrigin() + 1);
        GameStats stats = new GameStats(config.getStatsOriginX(), config.getStatsOriginY());
        return new ShootingShipState(playerShip, computerShip, stats);
    }
}
