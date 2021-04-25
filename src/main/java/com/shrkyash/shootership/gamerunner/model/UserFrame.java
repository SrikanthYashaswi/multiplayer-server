package com.shrkyash.shootership.gamerunner.model;

import com.shrkyash.shootership.gameinstance.models.base.BaseFrame;

public class UserFrame {
    public final String userId;
    public final BaseFrame baseFrame;

    public UserFrame(String userId, BaseFrame baseFrame) {
        this.userId = userId;
        this.baseFrame = baseFrame;
    }
}
