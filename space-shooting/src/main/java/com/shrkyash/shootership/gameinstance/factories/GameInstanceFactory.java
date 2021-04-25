package com.shrkyash.shootership.gameinstance.factories;

import com.shrkyash.shootership.gameinstance.Config;
import com.shrkyash.shootership.gameinstance.models.base.GameEnvironment;

public class GameInstanceFactory {
    public static GameEnvironment defaultInstance() {
        final var config = new Config(60, 30, 0, 1);
        return SimpleShootingShipEnvironmentFactory.getEnvironment(config);
    }
}
