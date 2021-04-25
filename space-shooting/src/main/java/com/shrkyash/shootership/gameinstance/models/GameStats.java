package com.shrkyash.shootership.gameinstance.models;

import com.shrkyash.shootership.gameinstance.models.base.Pixel;

public class GameStats extends Pixel {
    private int playerShipHealthPoints = 0;
    private int computerShipHealthPoints = 0;

    public GameStats(int x, int y) {
        super(x, y, "");
    }

    private String getUpdatedCharacter() {
        return "Player: " +
                "♥ ".repeat(playerShipHealthPoints) +
                "\t" +
                "Computer: " +
                "♥ ".repeat(computerShipHealthPoints);
    }

    private void updateCharacter() {
        this.setCharacter(getUpdatedCharacter());
    }

    public void setPlayerShipHealthPoints(int healthPoints) {
        this.playerShipHealthPoints = healthPoints;
        updateCharacter();
    }

    public void setComputerShipHealthPoints(int healthPoints){
        this.computerShipHealthPoints = healthPoints;
        updateCharacter();
    }

}
