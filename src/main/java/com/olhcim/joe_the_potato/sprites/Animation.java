package com.olhcim.joe_the_potato.sprites;

import com.olhcim.joe_the_potato.math.BoundingBox;
import java.awt.Graphics;

public class Animation implements GraphicsComponent {

    private long frameCount;
    private int countDelay;
    private int currentFrame;
    
    private boolean stopped;
    
    private Sprite[] frames;
    
    public Animation(Sprite[] frames, int countDelay) {
        
        if (frames.length < 1)
        {
            System.err.println("No sprites found");
            throw new RuntimeException("No sprites found");
        }
        if (countDelay <= 0) {
            System.err.println("Invalid duration: " + countDelay);
            throw new RuntimeException("Invalid duration: " + countDelay);
        }

        this.frameCount = 0;
        this.countDelay = countDelay;
        this.currentFrame = 0;
        this.stopped = true;
        this.frames = frames;
    }

    public Animation start() {
        stopped = false;
        return this;
    }

    public void stop() {
        stopped = true;
    }

    public void restart() {
        stopped = false;
        currentFrame = 0;
    }

    public void reset() {
        this.stopped = true;
        this.frameCount = 0;
        this.currentFrame = 0;
    }

    private Sprite getSprite() {
        return frames[currentFrame % frames.length];
    }

    public void update() {
        if (!stopped) {
            frameCount++;

            if (frameCount > countDelay) {
                frameCount = 0;
                currentFrame = (currentFrame+1) % frames.length;
            }
        }

    }

    @Override
    public int getWidth() {
        return getSprite().getWidth();
    }

    @Override
    public int getHeight() {
        return getSprite().getHeight();
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        getSprite().draw(g, x, y);
    }

    @Override
    public void drawFromCenter(Graphics g, int x, int y) {
        getSprite().drawFromCenter(g, x, y);
    }
    
    @Override
    public BoundingBox getBoundingBox()
    {
        return getSprite().getBoundingBox();
    }
}
