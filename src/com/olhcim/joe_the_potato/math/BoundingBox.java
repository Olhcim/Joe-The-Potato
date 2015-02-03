
package com.olhcim.joe_the_potato.math;

import java.awt.Graphics2D;

public class BoundingBox {
    
    private final double x0,x1,y0,y1;
    
    public BoundingBox(double x0, double y0, double x1, double y1)
    {
        this.x0 = Math.min(x0, x1);
        this.y0 = Math.min(y0, y1);
        this.x1 = Math.max(x0, x1);
        this.y1 = Math.max(y0, y1);
    }
    
    public BoundingBox(double x, double y)
    {
        this(0,0,x,y);
    }
    
    public boolean isColliding(BoundingBox other)
    {
        return x0 < other.x1 && x1 > other.x0 && y0 < other.y1 && y1 > other.y0; //if the squaresoverlap
    }
    
    public BoundingBox getOverlappingRegion(BoundingBox other)
    {
        return new BoundingBox(Math.min(x0, other.x0), Math.min(y0, other.y0), Math.min(x1, other.x1), Math.min(y1, other.y1));
    }
    
    public void draw(Graphics2D g)
    {
        g.drawRect((int)x0, (int)y0, (int)(x1-x0), (int)(y1-y0));
    }
    
    public static BoundingBox newTranslated(BoundingBox b, double x, double y)
    {
        return new BoundingBox(b.x0 + x, b.y0 + y, b.x1 + x, b.y1 + y);
    }
    
    public static BoundingBox newTranslatedCenter(BoundingBox b, double x, double y)
    {
        double tx = x - b.getWidth()/2;
        double ty = y - b.getHeight()/2;
        return new BoundingBox(b.x0 + tx, b.y0 + ty, b.x1 + tx, b.y1 + ty);
    }
    
    public double getWidth()
    {
        return Math.abs(x0 - x1);
    }
    public double getHeight()
    {
        return Math.abs(y0 - y1);
    }
    
    public String toString()
    {
        return "x0: " + x0 + "   y0: " + y0 + "   x1: " + x1 + "   y1: " + y1;
    }
}
