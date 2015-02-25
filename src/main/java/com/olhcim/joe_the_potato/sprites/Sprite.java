/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olhcim.joe_the_potato.sprites;

import com.olhcim.joe_the_potato.math.BoundingBox;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite implements GraphicsComponent {

    private BufferedImage image;
    private BoundingBox boundingBox;
    
    public Sprite(BufferedImage image)
    {
        this.image = image;
        boundingBox = new BoundingBox(image.getWidth(), image.getHeight());
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
