package com.shrkyash.shootership.gamerunner.services;

import com.shrkyash.shootership.gamerunner.config.GlobalConstants;
import com.shrkyash.shootership.gamerunner.model.MatchedPlayerGroup;
import com.shrkyash.shootership.gamerunner.pubsub.MessageDispatcher;
import com.shrkyash.shootership.gameinstance.factories.GameInstanceFactory;
import com.shrkyash.shootership.gameinstance.models.base.GameEnvironment;
import com.shrkyash.shootership.gameinstance.models.base.GameInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;
import java.util.Queue;

public class GameInstance extends Thread {
    private final Logger logger = LoggerFactory.getLogger(GameInstance.class);
    private final GameEnvironment gameEnvironment;
    private final MatchedPlayerGroup matchedPlayerGroup;
    private final MessageDispatcher messageDispatcher;
    private final Queue<GameInput> inputQueue;
    private boolean isActive = true;

    public GameInstance(MatchedPlayerGroup matchedPlayerGroup, MessageDispatcher messageDispatcher) {
        this.matchedPlayerGroup = matchedPlayerGroup;
        this.messageDispatcher = messageDispatcher;
        this.gameEnvironment = GameInstanceFactory.defaultInstance();
        this.inputQueue = new PriorityQueue<>();
    }

    @Override
    public void run() {
        while (isActive) {
            this.refresh();
            this.sleep();
        }
        this.logger.info("shutting down instance [{}] as user has quit the game.", matchedPlayerGroup.id);
    }

    public void refresh() {
        final var nextInput = getNextInput();
        if (GameInput.QUIT.equals(nextInput)) {
            isActive = false;
        }
        final var updatedFrame = this.gameEnvironment.updateEnvironment(nextInput);
        this.matchedPlayerGroup.users.forEach(user ->
                this.messageDispatcher.dispatchMessage(user.getId(), updatedFrame));
    }

    public void queueMessage(GameInput message) {
        this.inputQueue.add(message);
    }

    private GameInput getNextInput() {
        final var nextInput = inputQueue.poll();
        if (nextInput == null) {
            return GameInput.UNDEFINED;
        }
        return nextInput;
    }

    private void sleep() {
        try {
            sleep(GlobalConstants.sleepTimeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
