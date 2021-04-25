package com.shrkyash.shootership.gameinstance.models;

import com.shrkyash.shootership.gameinstance.models.base.Direction;
import com.shrkyash.shootership.gameinstance.models.base.Ship;

public class PlayerShip extends Ship {

    public PlayerShip(int x, int y) {
        super(x, y, ">", 3);
        this.setCannonDirection(Direction.RIGHT);
    }
}
