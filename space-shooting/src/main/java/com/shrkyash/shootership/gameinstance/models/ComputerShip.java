package com.shrkyash.shootership.gameinstance.models;

import com.shrkyash.shootership.gameinstance.models.base.Direction;
import com.shrkyash.shootership.gameinstance.models.base.Ship;

public class ComputerShip extends Ship {
    public ComputerShip(int x, int y) {
        super(x, y, "<", 2);
        setCannonDirection(Direction.LEFT);
    }
}
