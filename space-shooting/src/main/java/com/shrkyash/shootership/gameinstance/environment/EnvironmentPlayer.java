package com.shrkyash.shootership.gameinstance.environment;

import com.shrkyash.shootership.gameinstance.models.base.GameEnvironment;
import com.shrkyash.shootership.gameinstance.models.base.GameWindow;

public class EnvironmentPlayer {
    private final int sleepTimeInMillis = 15;
    private final GameWindow gameWindow;
    private final GameEnvironment gameEnvironment;

    private boolean shouldRun = true;

    public EnvironmentPlayer(GameWindow gameWindow, GameEnvironment gameEnvironment) {
        this.gameWindow = gameWindow;
        this.gameEnvironment = gameEnvironment;
    }

    public void run() {
        while (shouldRun) {
            var gameInput = gameWindow.getInputAsync();
            var frame = gameEnvironment.updateEnvironment(gameInput);
            gameWindow.clearScreen();
            gameWindow.print(frame);
            gameWindow.refresh();
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(sleepTimeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
