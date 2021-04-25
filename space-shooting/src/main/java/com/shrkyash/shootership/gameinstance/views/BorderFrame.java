package com.shrkyash.shootership.gameinstance.views;

import com.shrkyash.shootership.gameinstance.models.Frame;

public class BorderFrame extends Frame {

    public BorderFrame(int x1, int y1, int x2, int y2) {
        super();
        for (int i = x1 + 1; i < x2; i++) {
            addPixel(i, y1, "-");
            addPixel(i, y2, "-");
        }
        for (int j = y1 + 1; j < y2; j++) {
            addPixel(x1, j, "|");
            addPixel(x2, j, "|");
        }
        addPixel(x2, y1, "┐");
        addPixel(x2, y2, "┘");
        addPixel(x1, y1, "┌");
        addPixel(x1, y2, "└");
    }
}
