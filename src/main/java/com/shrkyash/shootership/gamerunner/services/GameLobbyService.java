package com.shrkyash.shootership.gamerunner.services;

import com.shrkyash.shootership.gamerunner.config.GlobalConstants;
import com.shrkyash.shootership.gamerunner.model.MatchedPlayerGroup;
import com.shrkyash.shootership.gamerunner.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameLobbyService {
    private final Logger logger = LoggerFactory.getLogger(GameLobbyService.class);
    private final Queue<User> userQueue;

    public GameLobbyService() {
        this.userQueue = new LinkedList<>();
    }

    public void addUserToLobby(User user) {
        this.logger.info("User [{}] jumped into the lobby", user.getId());
        this.userQueue.add(user);
    }

    public List<MatchedPlayerGroup> matchPlayers() {
        final var usersInQueue = userQueue.size();
        final int possibleGroups = usersInQueue / GlobalConstants.groupSize;
        List<MatchedPlayerGroup> matchedPlayers = new ArrayList<>();
        for (int i = 0; i < possibleGroups; i++) {
            List<User> group = new ArrayList<>();
            for (int j = 0; j < GlobalConstants.groupSize; j++) {
                group.add(userQueue.poll());
            }
            matchedPlayers.add(new MatchedPlayerGroup(group));
        }
        this.logger.info("[{}] groups are proceeding to match", possibleGroups);
        this.logger.info("[{}] user(s) waiting in lobby", this.userQueue.size());
        return matchedPlayers;
    }
}
