package com.shrkyash.shootership.gameinstance.factories;

import com.shrkyash.shootership.gameinstance.Config;
import com.shrkyash.shootership.gameinstance.controller.Controller;
import com.shrkyash.shootership.gameinstance.environment.ShootingShipEnvironment;
import com.shrkyash.shootership.gameinstance.models.ShootingShipState;
import com.shrkyash.shootership.gameinstance.models.base.BaseFrame;
import com.shrkyash.shootership.gameinstance.models.base.GameEnvironment;
import com.shrkyash.shootership.gameinstance.views.BorderFrame;

public class SimpleShootingShipEnvironmentFactory {
    private SimpleShootingShipEnvironmentFactory() {
    }

    public static GameEnvironment getEnvironment(Config config) {

        Controller<ShootingShipState> controllerChain = ShootingShipControllerFactory.getControllerChain(config);

        ShootingShipState state = ShootingShipStateFactory.getState(config);

        BaseFrame border = new BorderFrame(config.getPlayAreaXOrigin(), config.getPlayAreaYOrigin(),
                config.getWindowWidth() - 1, config.getWindowHeight() - 1);

        return new ShootingShipEnvironment(state, controllerChain, border);
    }
}
