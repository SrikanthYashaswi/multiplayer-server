package com.shrkyash.shootership.gameinstance.controller;

import com.shrkyash.shootership.gameinstance.models.ShootingShipState;
import com.shrkyash.shootership.gameinstance.models.base.Sprite;

public class InactiveSpriteFlusher extends Controller<ShootingShipState> {

    @Override
    public void update(ShootingShipState state) {
        state.getBullets().removeIf(Sprite::isInactive);
    }
}
