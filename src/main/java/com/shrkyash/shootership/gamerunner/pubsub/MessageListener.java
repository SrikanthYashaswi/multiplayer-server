package com.shrkyash.shootership.gamerunner.pubsub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shrkyash.shootership.gamerunner.model.MatchedPlayerGroup;
import com.shrkyash.shootership.gamerunner.services.GameInstanceManager;
import com.shrkyash.shootership.gamerunner.services.GameLobbyService;
import com.shrkyash.shootership.gamerunner.utils.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@EnableBinding({Sink.class, UserInputSink.class})
@Component
public class MessageListener {
    private final GameLobbyService gameLobbyService;
    private final GameInstanceManager gameInstanceManager;
    private final TypeConverter typeConverter;
    private final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    public MessageListener(GameLobbyService gameLobbyService, GameInstanceManager gameInstanceManager, TypeConverter typeConverter) {
        this.gameLobbyService = gameLobbyService;
        this.gameInstanceManager = gameInstanceManager;
        this.typeConverter = typeConverter;
    }

    @StreamListener(target = Sink.INPUT)
    public void createUser(String encodedUser) throws JsonProcessingException {
        final var user = this.typeConverter.getUser(encodedUser);
        this.gameLobbyService.addUserToLobby(user);
        this.matchUsers();
    }

    @StreamListener(target = UserInputSink.INPUT)
    public void updateUserCommands(String encodedInput) throws JsonProcessingException {
        final var input = this.typeConverter.getUserInput(encodedInput);
        this.gameInstanceManager.updateInput(input);
    }

    private void matchUsers() {
        final var matchedPlayers = this.gameLobbyService.matchPlayers();
        for (MatchedPlayerGroup matchedPlayer : matchedPlayers) {
            this.gameInstanceManager.createGameInstance(matchedPlayer);
        }
    }
}
