package com.shrkyash.shootership.gamerunner.pubsub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shrkyash.shootership.gamerunner.services.GameInstanceManager;
import com.shrkyash.shootership.gamerunner.services.GameLobbyService;
import com.shrkyash.shootership.gamerunner.utils.TypeConverter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MessageListenerTest {

    @Mock
    private GameLobbyService gameLobbyService;

    @Mock
    private GameInstanceManager gameInstanceManager;

    @Mock
    private TypeConverter converter;

    @InjectMocks
    private MessageListener messageListener;

    @Test
    void createUser() throws JsonProcessingException {
        String user = "{\"id\":\"srikanth1234\",\"name\":\"srikanth\"}";
        this.messageListener.createUser(user);
    }

    @Test
    void updateUserCommands() {
    }
}