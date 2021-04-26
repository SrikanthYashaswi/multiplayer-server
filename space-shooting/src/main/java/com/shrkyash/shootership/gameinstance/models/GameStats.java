package com.shrkyash.shootership.gameinstance.models;

import com.shrkyash.shootership.gameinstance.models.base.Pixel;

public class GameStats extends Pixel {
    private int leftShipHealth = 0;
    private int rightShipHealth = 0;

    public GameStats(int x, int y) {
        super(x, y, "");
    }

    private String getUpdatedCharacter() {
        return "Left Ship: " +
                "♥ ".repeat(leftShipHealth) +
                "\t" +
                "Right Ship: " +
                "♥ ".repeat(rightShipHealth);
    }

    private void updateCharacter() {
        this.setCharacter(getUpdatedCharacter());
    }

    public void setLeftShipHealth(int healthPoints) {
        this.leftShipHealth = healthPoints;
        updateCharacter();
    }

    public void setRightShipHealth(int healthPoints){
        this.rightShipHealth = healthPoints;
        updateCharacter();
    }

}
