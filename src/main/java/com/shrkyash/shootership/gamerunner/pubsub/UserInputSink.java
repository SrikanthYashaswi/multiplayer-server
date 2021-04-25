package com.shrkyash.shootership.gamerunner.pubsub;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserInputSink {
    String INPUT = "userInputSink";

    @Input("userInputSink")
    SubscribableChannel input();
}
