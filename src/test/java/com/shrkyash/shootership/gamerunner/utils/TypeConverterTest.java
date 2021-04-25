package com.shrkyash.shootership.gamerunner.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

class TypeConverterTest {

    TypeConverter converter = new TypeConverter();

    @Test
    void getUser() throws JsonProcessingException {
        final var user = converter.getUser("{\"id\":\"srikanth1234\",\"name\":\"srikanth\"}");
    }
}