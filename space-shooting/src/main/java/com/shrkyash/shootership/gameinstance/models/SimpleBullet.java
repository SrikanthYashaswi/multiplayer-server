package com.shrkyash.shootership.gameinstance.models;

import com.shrkyash.shootership.gameinstance.models.base.Bullet;
import com.shrkyash.shootership.gameinstance.models.base.Direction;

public class SimpleBullet extends Bullet {
    public SimpleBullet(int x, int y, Direction travelDirection) {
        super(x, y, "-", 1, travelDirection);
    }
}
