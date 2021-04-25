package com.shrkyash.shootership.gameinstance.controller;

import com.shrkyash.shootership.gameinstance.models.ShootingShipState;

public class GameStatsUpdater extends Controller<ShootingShipState> {

    @Override
    public void update(ShootingShipState state) {
        var gameStats = state.getStats();
        gameStats.setPlayerShipHealthPoints(state.getPlayerShip().getHealth());
        gameStats.setComputerShipHealthPoints(state.getComputerShip().getHealth());
    }
}
