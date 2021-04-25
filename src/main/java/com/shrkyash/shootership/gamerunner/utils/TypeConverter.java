package com.shrkyash.shootership.gamerunner.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shrkyash.shootership.gamerunner.model.User;
import com.shrkyash.shootership.gamerunner.model.UserInput;
import org.springframework.stereotype.Component;

@Component
public class TypeConverter {
    private final ObjectMapper objectMapper;

    public TypeConverter() {
        this.objectMapper = new ObjectMapper();
    }

    public User getUser(String user) throws JsonProcessingException {
        return this.objectMapper.readValue(user, User.class);
    }

    public UserInput getUserInput(String userInput) throws JsonProcessingException {
        return this.objectMapper.readValue(userInput, UserInput.class);
    }
}
