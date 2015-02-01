package com.olhcim.joe_the_potato.screens;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

public abstract class Screen implements KeyListener {
    
    private boolean fadingIn = false;
    private boolean fadingOut = false;
    private final int fadeMax = 1000;
    private int fadePos = 0;
    private byte fadeSpeed = 1;

    public void fadeIn(byte speed) {

        if (speed < 1) {
            speed = 1;
        }

        fadingIn = true;
        fadingOut = false;
        fadePos = 0;
        fadeSpeed = speed;
    }

    public void fadeOut(byte speed) {
        if (speed < 1) {
            speed = 1;
        }

        fadingIn = false;
        fadingOut = true;
        fadePos = 0;
        fadeSpeed = speed;
    }

    public Screen updateScreen() {
        if (fadingIn || fadingOut) {

            if (fadingIn && fadePos >= fadeMax) {
                fadingIn = false;
                fadingOut = false;
            }

            fadePos += fadeSpeed;

            if (fadePos > fadeMax) {
                fadePos = fadeMax;
            }
        }

        
        return update();
    }

    public void drawScreen(Graphics2D g, int width, int height) {

        draw(g, width, height);

        if (fadingIn || fadingOut) {
            float transparency = (float) fadePos / ((fadingIn) ? fadeMax - fadePos : fadePos);
            g.setColor(new Color(0, 0, 0, transparency));
            g.fillRect(0, 0, width, height);
        }
    }
    
    public abstract int getWidth();
    public abstract int getHeight();

    public abstract void draw(Graphics2D g, int width, int height);

    protected abstract Screen update();
}
