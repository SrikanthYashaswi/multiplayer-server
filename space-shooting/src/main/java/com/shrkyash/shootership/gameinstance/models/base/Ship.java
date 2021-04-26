package com.shrkyash.shootership.gameinstance.models.base;

public class Ship extends Mass {

    private Direction cannonDirection;

    private String playerId;

    public Ship(int x, int y, String c, int health) {
        super(x, y, c, health);
    }

    public Ship(int x, int y, String c, int health, Direction cannonDirection) {
        super(x, y, c, health);
        this.cannonDirection = cannonDirection;
    }

    public Direction getCannonDirection() {
        return cannonDirection;
    }

    public void setCannonDirection(Direction cannonDirection) {
        this.cannonDirection = cannonDirection;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
