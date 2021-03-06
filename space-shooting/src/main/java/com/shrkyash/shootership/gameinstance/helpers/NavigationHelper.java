package com.shrkyash.shootership.gameinstance.helpers;

import com.shrkyash.shootership.gameinstance.models.base.GameInput;
import com.shrkyash.shootership.gameinstance.models.base.Location;

public class NavigationHelper {

    private NavigationHelper() {
    }

    public static Location getNext(GameInput userInput, int x, int y) {
        switch (userInput) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
            default:
        }
        return new Location(x, y);
    }
}
