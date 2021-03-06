
package com.olhcim.joe_the_potato;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Canvas extends JPanel
{
    private final BufferedImage image;
    private final double scale;
    
    public Canvas(int width, int height, double scale) 
    {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        width *= scale;
        height *= scale;
        
        Dimension size = new Dimension(width, height);
        this.setSize(size);
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        
        this.scale = scale;
    }
    
    public Canvas(int width, int height) 
    {
        this(width, height, 1);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.scale(scale, scale);
        
        int tx = (int) ((this.getWidth() - image.getWidth()*scale) / (2.0 * scale));
        int ty = (int) ((this.getHeight() - image.getHeight()*scale) / (2.0 * scale));
//        
        g2d.drawImage(image, tx, ty, null);
//        g2d.drawImage(image, 0, 0, null);
    }
    
    public Graphics2D getImageGraphics()
    {
        return (Graphics2D) image.getGraphics();
    }
    
    public int getImageWidth()
    {
        return image.getWidth();
    }
    public int getImageHeight()
    {
        return image.getHeight();
    }
    
    public int canvasWidth()
    {
        return (int)(image.getWidth() * scale);
    }
    public int canvasHeight()
    {
        return (int)(image.getHeight() * scale);
    }
    
    public double getScale()
    {
        return scale;
    }
}
