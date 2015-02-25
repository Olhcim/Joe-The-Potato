package com.olhcim.joe_the_potato.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;


public class ResourceLoader {

    private static final HashMap<String, BufferedImage> images = new HashMap<>();
    private static final HashMap<String, Sprite> sprites = new HashMap<>();
    private static final HashMap<String, Animation> animations = new HashMap<>();
    
    private static void loadImage(String imageName) {
        if (!images.containsKey(imageName)) {
            imageName += ".png";
            URL url = ResourceLoader.class.getClassLoader().getResource(imageName);
            BufferedImage image;
            try {
                image = ImageIO.read(url);
            } catch (IOException ex) {
                System.err.println(imageName + " could not be loaded, or is missing!");
                image = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
                drawMissingTexture(image);
            }
            images.put(imageName, image);
        }
    }
    
    private static void drawMissingTexture(BufferedImage image) {
        Graphics g = image.getGraphics();
        g.setColor(Color.MAGENTA);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i + j) % 2 == 0) {
                    int width = image.getWidth() / 4;
                    int height = image.getHeight() / 4;
                    int x = i * width;
                    int y = j * height;
                    g.setColor(Color.PINK);
                    g.fillRect(x, y, width, height);
                }
            }
        }
    }
    
    public static void loadSprite(String imageName)
    {
        if (!sprites.containsKey(imageName)) {
            loadImage(imageName);
            sprites.put(imageName, new Sprite(getImage(imageName)) );
        }
    }
    
    public static void loadAnimation(String imageName, int numFrames)
    {
        if (!animations.containsKey(imageName)) {
            loadImage(imageName);
            
            BufferedImage image = getImage(imageName);
            Sprite[] spriteAnim = new Sprite[numFrames];
            
            int gap = image.getWidth() / numFrames;
            
            for(int i = 0; i < numFrames; i++)
            {
                int x = i * gap;
                spriteAnim[i] = new Sprite( image.getSubimage(x, 0, image.getHeight(), gap) );
            }
            
            animations.put(imageName, new Animation(spriteAnim,2));
        }
    }
    
    public static BufferedImage getImage(String imageName)
    {
        return images.get(imageName);
    }
    
    public static Sprite getSprite(String imageName)
    {
        return sprites.get(imageName);
    }
    
    public static Animation getAnimation(String imageName)
    {
        return animations.get(imageName);
    }
}
