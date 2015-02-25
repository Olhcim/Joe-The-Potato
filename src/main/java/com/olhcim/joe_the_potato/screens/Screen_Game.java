
package com.olhcim.joe_the_potato.screens;

import com.olhcim.joe_the_potato.entities.EntityLiving;
import com.olhcim.joe_the_potato.entities.Mob_Player;
import com.olhcim.joe_the_potato.entities.Particle;
import com.olhcim.joe_the_potato.sprites.ResourceLoader;
import com.olhcim.joe_the_potato.sprites.Sprite;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Screen_Game extends Screen {

    private static Sprite background;
    private static Sprite doorTop;
    
    public Screen_Game()
    {
        if (background == null)
            background = ResourceLoader.getSprite("background");
        
        player = new Mob_Player(100,100);
        livingEntities = new ArrayList<>();
        particals = new ArrayList<>();
    }
    
    public Mob_Player player;
    public ArrayList<EntityLiving> livingEntities;
    public ArrayList<Particle> particals;
    
    @Override
    public void draw(Graphics2D g, int width, int height) {
        background.draw(g, 0, 0);
        
        for (EntityLiving e : livingEntities)
        {
            e.draw(g);
        }
        
        player.draw(g);
        
    }

    @Override
    protected Screen update() {
        player.update();
        
        for (EntityLiving e : livingEntities)
        {
            e.update();
        }

        return this;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
//            case KeyEvent.VK_UP :       player.shoot(0,-1);
//                break;
//            case KeyEvent.VK_LEFT :     player.shoot(-1,0);
//                break;
//            case KeyEvent.VK_DOWN :     player.shoot(0,1);
//                break;
//            case KeyEvent.VK_RIGHT :    player.shoot(1,0);
//                break;
                
            case KeyEvent.VK_W :    player.walk(Mob_Player.DIR_UP, true);
                break;
            case KeyEvent.VK_A :    player.walk(Mob_Player.DIR_LEFT, true);
                break;
            case KeyEvent.VK_S :    player.walk(Mob_Player.DIR_DOWN, true);
                break;
            case KeyEvent.VK_D :    player.walk(Mob_Player.DIR_RIGHT, true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_W :    player.walk(Mob_Player.DIR_UP, false);
                break;
            case KeyEvent.VK_A :    player.walk(Mob_Player.DIR_LEFT, false);
                break;
            case KeyEvent.VK_S :    player.walk(Mob_Player.DIR_DOWN, false);
                break;
            case KeyEvent.VK_D :    player.walk(Mob_Player.DIR_RIGHT, false);
                break;
        }
    }

    @Override
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }
}
