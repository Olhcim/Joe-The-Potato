package com.olhcim.joe_the_potato.sprites;

import com.olhcim.joe_the_potato.Main;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Animation implements GraphicsComponent {

    private int frameCount;
    private int countDelay;
    private int currentFrame;
    
    private boolean stopped;
    
    private List<Sprite> frames = new ArrayList<>();    // Arraylist of frames 

    public Animation(String name, int countDelay) {

        String baseFolder = Main.class.getResource("resources").getFile();
        File baseFile = new File(baseFolder);
        
        if (!baseFile.exists() || !baseFile.canRead()) {
            System.err.println("The resources dir does not exist or cannot be read: " + baseFile.toString());
            throw new RuntimeException("The resources dir does not exist or cannot be read: " + baseFile.toString());
        }
        if (name.trim().isEmpty()) {
            System.err.println("Invalid image set base name: " + name);
            throw new RuntimeException("Invalid image set base name: " + name);
        }
        if (countDelay <= 0) {
            System.err.println("Invalid duration: " + countDelay);
            throw new RuntimeException("Invalid duration: " + countDelay);
        }

        this.countDelay = countDelay;
        this.stopped = true;
        
        name = name.trim().replaceAll("[ \t\n]", "_");
        
        for (int i = 0; true; i++)
        {
            File current = new File(baseFolder + File.separatorChar + name + "_" + i + ".png");
            if (current.exists())
            {
                frames.add(new Sprite(current));
            } else {
                break;
            }
        }
        
        if (frames.size() < 1)
        {
            System.err.println("No sprites loaded: " + baseFolder + File.separatorChar + name + "_X" + ".png");
            throw new RuntimeException("No sprites loaded: " + baseFolder + File.separatorChar + name + "_X" + ".png");
        }

        this.frameCount = 0;
        this.countDelay = countDelay;
        this.currentFrame = 0;
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
        return frames.get(currentFrame);
    }

    public void update() {
        if (!stopped) {
            frameCount++;

            if (frameCount > countDelay) {
                frameCount = 0;
                currentFrame = (currentFrame+1) % frames.size();
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
}
