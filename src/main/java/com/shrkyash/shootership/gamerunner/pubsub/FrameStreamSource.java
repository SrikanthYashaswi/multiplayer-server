package com.shrkyash.shootership.gamerunner.pubsub;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface FrameStreamSource {
    @Output("frameStreamChannel")
    MessageChannel frameStreamChannel();
}
