package com.shrkyash.shootership.gamerunner.pubsub;

import com.shrkyash.shootership.gameinstance.models.base.BaseFrame;
import com.shrkyash.shootership.gamerunner.model.UserFrame;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


@Component
public class MessageDispatcher {

    private final FrameStreamSource frameStreamSource;

    public MessageDispatcher(FrameStreamSource frameStreamSource) {
        this.frameStreamSource = frameStreamSource;
    }

    public void dispatchMessage(String userId, BaseFrame baseFrame) {
        frameStreamSource.frameStreamChannel().send(MessageBuilder.withPayload(new UserFrame(userId, baseFrame)).build());
    }
}
