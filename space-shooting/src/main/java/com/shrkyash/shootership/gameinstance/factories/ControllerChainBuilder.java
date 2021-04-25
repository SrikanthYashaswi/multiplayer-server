package com.shrkyash.shootership.gameinstance.factories;

import com.shrkyash.shootership.gameinstance.controller.Controller;
import com.shrkyash.shootership.gameinstance.models.ShootingShipState;

public class ControllerChainBuilder {
    Controller<ShootingShipState> chainHead;
    Controller<ShootingShipState> previous;

    private ControllerChainBuilder() {
        this.chainHead = null;
    }

    public static ControllerChainBuilder getInstance() {
        return new ControllerChainBuilder();
    }

    public ControllerChainBuilder setNext(Controller<ShootingShipState> nextController) {
        if (chainHead == null) {
            chainHead = nextController;
        } else {
            previous.setNextController(nextController);
        }
        previous = nextController;
        return this;
    }

    public Controller<ShootingShipState> buildChain() {
        return chainHead;
    }
}
