package com.shrkyash.shootership.gamerunner.pubsub;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(UserInputSink.class)
public class UserInputListener {
}
