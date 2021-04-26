package com.shrkyash.shootership.gameinstance.models;

import com.shrkyash.shootership.gameinstance.models.base.Bullet;
import com.shrkyash.shootership.gameinstance.models.base.Ship;

import java.util.ArrayList;
import java.util.List;

public class ShootingShipState {
    private final List<Ship> playerShips;

    private final List<Bullet> bullets;
    private final GameStats stats;
    private UserInput userInput;

    public ShootingShipState(List<Ship> playerShips, GameStats stats) {
        this.playerShips = playerShips;
        this.stats = stats;
        bullets = new ArrayList<>();
    }

    public List<Ship> getPlayerShips() {
        return playerShips;
    }

    public List<Bullet> getBullets() {
        return this.bullets;
    }

    public void addBullet(Bullet bullet) {
        this.bullets.add(bullet);
    }

    public GameStats getStats() {
        return stats;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public void setUserInput(UserInput lastUserInput) {
        this.userInput = lastUserInput;
    }

    public Frame toFrame() {
        Frame frame = new Frame();
        playerShips.forEach(frame::addPixel);
        frame.addPixel(stats);
        frame.addPixels(new ArrayList<>(bullets));
        return frame;
    }
}
