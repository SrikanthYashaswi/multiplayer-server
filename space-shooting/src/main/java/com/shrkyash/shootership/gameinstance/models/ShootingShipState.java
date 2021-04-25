package com.shrkyash.shootership.gameinstance.models;

import com.shrkyash.shootership.gameinstance.models.base.Bullet;
import com.shrkyash.shootership.gameinstance.models.base.GameInput;

import java.util.ArrayList;
import java.util.List;

public class ShootingShipState  {
    private final PlayerShip playerShip;
    private final ComputerShip computerShip;
    private final List<Bullet> bullets;
    private final GameStats stats;
    private GameInput userInput;

    public ShootingShipState(PlayerShip playerShip, ComputerShip computerShip, GameStats stats) {
        this.playerShip = playerShip;
        this.computerShip = computerShip;
        this.stats = stats;
        bullets = new ArrayList<>();
    }

    public PlayerShip getPlayerShip() {
        return playerShip;
    }

    public ComputerShip getComputerShip() {
        return computerShip;
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

    public GameInput getUserInput() {
        return userInput;
    }

    public void setUserInput(GameInput lastUserInput) {
        this.userInput = lastUserInput;
    }

    public Frame toFrame() {
        Frame frame = new Frame();
        frame.addPixel(playerShip);
        frame.addPixel(computerShip);
        frame.addPixel(stats);
        frame.addPixels(new ArrayList<>(bullets));
        return frame;
    }
}
