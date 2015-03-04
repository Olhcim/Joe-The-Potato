
package com.olhcim.potato.util;

import com.badlogic.ashley.core.Entity;
import com.olhcim.potato.components.*;
import com.olhcim.potato.components.Renderable.Layer;

/**
 *
 * @author Nathan
 */
public class EntityFactory {
    
    public static Entity createPlayer(float x, float y)
    {
        Entity e = new Entity();
            e.add( new Player() );
            e.add( new Health(6) );
            //change to get from current room
            e.add( new Bounds(0,0,1000,1000));
            e.add( new Collide(20) );
            e.add( new Velocity(0,0) );
            e.add( new Position(x,y) );
            //change to get start from current room;
            e.add( new Renderable( "potato", Layer.PLAYER ) );
        return e;
    }
    
    public static Entity createBullet(float x, float y, float vx, float vy, float dist)
    {
        Entity e = new Entity();
            //change to get from current room
            e.add( new Bounds(0,0,1000,1000));
            e.add( new Collide(8) );
            e.add( new Velocity(vx,vy,0) );
            e.add( new Position(x,y) );
            e.add( new DistExpire(x,y,dist) );
            //change to get start from current room;
            e.add( new Renderable( "shot", Layer.ENEMIES ) );
        return e;
    }
    
}
