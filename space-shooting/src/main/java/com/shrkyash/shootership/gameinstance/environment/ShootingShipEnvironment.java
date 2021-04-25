package com.shrkyash.shootership.gameinstance.environment;

import com.shrkyash.shootership.gameinstance.models.base.GameEnvironment;
import com.shrkyash.shootership.gameinstance.controller.Controller;
import com.shrkyash.shootership.gameinstance.models.Frame;
import com.shrkyash.shootership.gameinstance.models.ShootingShipState;
import com.shrkyash.shootership.gameinstance.models.base.BaseFrame;
import com.shrkyash.shootership.gameinstance.models.base.GameInput;

public class ShootingShipEnvironment implements GameEnvironment {
    private final BaseFrame[] staticFrames;
    private final ShootingShipState state;
    private final Controller<ShootingShipState> controllerChain;

    public ShootingShipEnvironment(ShootingShipState state, Controller<ShootingShipState> controllerChain, BaseFrame... staticFrames) {
        this.state = state;
        this.controllerChain = controllerChain;
        this.staticFrames = staticFrames;
    }

    @Override
    public BaseFrame updateEnvironment(GameInput input) {
        state.setUserInput(input);
        controllerChain.execute(state);
        return buildFrame();
    }

    private BaseFrame buildFrame() {
        Frame frame = state.toFrame();
        for (BaseFrame staticFrame : this.staticFrames) {
            frame.addPixels(staticFrame.getPixels());
        }
        return frame;
    }
}
