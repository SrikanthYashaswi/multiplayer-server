package com.shrkyash.shootership.gameinstance.factories;

import com.shrkyash.shootership.gameinstance.controller.*;
import com.shrkyash.shootership.gameinstance.Config;
import com.shrkyash.shootership.gameinstance.models.ShootingShipState;

public class ShootingShipControllerFactory {
    private ShootingShipControllerFactory() {
    }

    public static Controller<ShootingShipState> getControllerChain(Config config) {
        return ControllerChainBuilder
                .getInstance()
                .setNext(new PlayerShipController(config))
                .setNext(new BulletController(config.getWindowWidth() - 2))
                .setNext(new CollisionDetector())
                .setNext(new GameStatsUpdater())
                .setNext(new InactiveSpriteFlusher())
                .buildChain();
    }
}
