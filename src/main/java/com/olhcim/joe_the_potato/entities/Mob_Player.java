package com.olhcim.joe_the_potato.entities;

import com.olhcim.joe_the_potato.sprites.Animation;
import com.olhcim.joe_the_potato.sprites.ResourceLoader;
import java.util.HashMap;
import java.util.Map;

public class Mob_Player extends EntityLiving {

    public static final int DIR_UP = 0;
    public static final int DIR_LEFT = 1;
    public static final int DIR_DOWN = 2;
    public static final int DIR_RIGHT = 3;
    
    private boolean walkingUp = false;
    private boolean walkingLeft = false;
    private boolean walkingDown = false;
    private boolean walkingRight = false;
    
    public Mob_Player(double x, double y) {
        super(x, y);
    }
    
    @Override
    public void update()
    {
        
        
        if(walkingUp)
            vely = -3;
        if(walkingLeft)
            velx = -3;
        if(walkingDown)
            vely = 3;
        if(walkingRight)
            velx = 3;
        
        posx += velx;
        posy += vely;
        
        velx *= 0.75;
        vely *= 0.75;
        
        if (velx < 0.1 && velx > -0.1) { velx = 0; }
        if (vely < 0.1 && vely > -0.1) { vely = 0; }
        
        getCurrentAnimation().update();
    }

    @Override
    protected int getMaxHealth() {
        return 6;
    }

    @Override
    protected int getAttackStrength() {
        return 1;
    }

    @Override
    protected void onDeath() {}

    @Override
    public void attack(EntityLiving target) {}
    
    public void walk (int dir, boolean start)
    {
        if (start)
        {
            switch(dir)
            {
                case DIR_UP :       walkingUp = true; walkingLeft = false; walkingDown = false; walkingRight = false;
                    break;
                case DIR_LEFT :     walkingUp = false; walkingLeft = true; walkingDown = false; walkingRight = false;
                    break;
                case DIR_DOWN :     walkingUp = false; walkingLeft = false; walkingDown = true; walkingRight = false;
                    break;
                case DIR_RIGHT :    walkingUp = false; walkingLeft = false; walkingDown = false; walkingRight = true;
                    break;
            }
        } else {
            switch(dir)
            {
                case DIR_UP :       walkingUp = false;
                    break;
                case DIR_LEFT :     walkingLeft = false;
                    break;
                case DIR_DOWN :     walkingDown = false;
                    break;
                case DIR_RIGHT :    walkingRight = false;
                    break;
            }
        }
    }
    
    public void attack (int dirx, int diry)
    {
        if (Math.abs(dirx) + Math.abs(diry) != 1)
            return;
    }

    @Override
    protected Map<String, Animation> loadAnimations() {
        Map<String, Animation> anims = new HashMap<>();
        
        anims.put("idle", ResourceLoader.getAnimation("Potato_Walk").start());
        
        return anims;
    }
}
