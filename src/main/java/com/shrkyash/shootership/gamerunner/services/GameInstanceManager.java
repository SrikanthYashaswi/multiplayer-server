package com.shrkyash.shootership.gamerunner.services;

import com.shrkyash.shootership.gamerunner.model.MatchedPlayerGroup;
import com.shrkyash.shootership.gameinstance.models.UserInput;
import com.shrkyash.shootership.gamerunner.pubsub.MessageDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Component
public class GameInstanceManager {
    private final Logger logger = LoggerFactory.getLogger(GameInstanceManager.class);
    private final Map<String, GameInstance> gameInstanceThreads;
    private final Map<String, String> userGameInstanceMap;
    private final MessageDispatcher messageDispatcher;
    private final Queue<MatchedPlayerGroup> matchedPlayerGroups = new LinkedList<>();

    public GameInstanceManager(MessageDispatcher messageDispatcher) {
        this.messageDispatcher = messageDispatcher;
        this.gameInstanceThreads = new HashMap<>();
        this.userGameInstanceMap = new HashMap<>();
    }

    public void createGameInstance(MatchedPlayerGroup matchedPlayerGroup) {
        logger.info("Creating a new game instance with id [{}]", matchedPlayerGroup.id);

        final var gameInstance = new GameInstance(matchedPlayerGroup, this.messageDispatcher);
        this.gameInstanceThreads.put(matchedPlayerGroup.id, gameInstance);
        this.mapUserToInstance(matchedPlayerGroup);
        gameInstance.start();

        logger.info("Started game instance with id [{}]", matchedPlayerGroup.id);
    }

    private void mapUserToInstance(MatchedPlayerGroup matchedPlayerGroup) {
        matchedPlayerGroup.users.forEach(user -> this.userGameInstanceMap.put(user.getId(), matchedPlayerGroup.id));
    }

    public void updateInput(UserInput userInput) {
        final var instanceId = this.userGameInstanceMap.get(userInput.getId());
        final var gameInstance = this.gameInstanceThreads.get(instanceId);
        if(gameInstance!= null){
            gameInstance.queueMessage(userInput);
        }
    }
}
