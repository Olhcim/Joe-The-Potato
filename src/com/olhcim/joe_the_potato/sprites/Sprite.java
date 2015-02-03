/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olhcim.joe_the_potato.sprites;

import com.olhcim.joe_the_potato.Main;
import com.olhcim.joe_the_potato.math.BoundingBox;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite implements GraphicsComponent {

    private BufferedImage image;
    private BoundingBox boundingBox;
    
    public Sprite(BufferedImage image)
    {
        this.image = image;
        boundingBox = new BoundingBox(image.getWidth(), image.getHeight());
    }
    
    public Sprite(String string)
    {
        this( new File( Main.class.getResource( "resources/" + string ).getPath() ) );
    }
    
    public Sprite(File file)
    {
        
        
        if(!file.isFile() || !file.getName().endsWith(".png"))
        {
            System.err.println("Invalid sprite png file: " + file);
            throw new RuntimeException("Invalid sprite png file: " + file);
        }
        
        try {
            image = ImageIO.read(file);
        } catch (IOException ex) {
            image = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
            System.err.println("The sprite file could not be loaded: " + file);
            throw new RuntimeException("The sprite file could not be loaded: " + file);
        }
    }
    
    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }
    
    @Override
    public BoundingBox getBoundingBox()
    {
        return boundingBox;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);
    }

    @Override
    public void drawFromCenter(Graphics g, int x, int y) {
        draw(g, x - getWidth()/2, y - getHeight()/2);
    }
    
}
