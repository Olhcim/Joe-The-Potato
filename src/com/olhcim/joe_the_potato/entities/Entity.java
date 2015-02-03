package com.olhcim.joe_the_potato.entities;


import com.olhcim.joe_the_potato.math.BoundingBox;
import com.olhcim.joe_the_potato.sprites.Animation;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Map;

public abstract class Entity {

    protected Map<String, Animation> animations;
    protected String currentAnimation = "idle";

    public double posx, posy, velx, vely;
    
    public Entity(double x, double y) {
        posx = x;
        posy = y;
        animations = loadAnimations();
    }
    
    protected abstract Map<String, Animation> loadAnimations();
    
    public void update()
    {
        posx += velx;
        posy += vely;
        
        velx *= 0.9;
        vely *= 0.9;
        
        if (velx < 0.1 && velx > -0.1) { velx = 0; }
        if (vely < 0.1 && vely > -0.1) { vely = 0; }
        
        getCurrentAnimation().update();
    }

    public void draw(Graphics2D g) {
        Animation current = getCurrentAnimation();
        if (current != null) {
            current.drawFromCenter(g, (int) posx, (int) posy);
        } else {
            g.setColor(Color.MAGENTA);
            g.fillRect((int) posx - 5, (int) posy - 5, 10, 10);
        }
        
        try {
        getTranslatedBoundingBox().draw(g);
        } catch (Exception e) {};
    }
    
    protected Animation getCurrentAnimation()
    {
        return animations.get(currentAnimation);
    }
    
    public BoundingBox getTranslatedBoundingBox()
    {
        return BoundingBox.newTranslatedCenter(getCurrentAnimation().getBoundingBox(), posx, posy);
    }
}
