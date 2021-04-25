package com.shrkyash.shootership.gameinstance;

public class Config {
    private final int windowWidth;
    private final int windowHeight;
    private final int playAreaXOrigin;
    private final int playAreaYOrigin;
    private final int playAreaXBoundary;
    private final int playAreaYBoundary;
    private final int statsOriginX;
    private final int statsOriginY;
    private final int computerShipMovementDelay;

    public Config(int windowWidth, int windowHeight, int playAreaXOrigin, int playAreaYOrigin) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.statsOriginX = 7;
        this.statsOriginY = 0;
        this.playAreaXOrigin = playAreaXOrigin;
        this.playAreaYOrigin = playAreaYOrigin;
        this.playAreaXBoundary = windowWidth - 1;
        this.playAreaYBoundary = windowHeight - 1;
        this.computerShipMovementDelay = 10;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public int getPlayAreaXOrigin() {
        return playAreaXOrigin;
    }

    public int getPlayAreaYOrigin() {
        return playAreaYOrigin;
    }

    public int getPlayAreaXBoundary() {
        return playAreaXBoundary;
    }

    public int getPlayAreaYBoundary() {
        return playAreaYBoundary;
    }

    public int getStatsOriginX() {
        return statsOriginX;
    }

    public int getStatsOriginY() {
        return statsOriginY;
    }

    public int getComputerShipMovementDelay() {
        return computerShipMovementDelay;
    }
}
