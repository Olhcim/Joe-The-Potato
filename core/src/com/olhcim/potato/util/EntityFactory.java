
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
            //change to get start from current room;
            e.add( new Renderable( FileUtil.loadCenteredSprite("badlogic", "jpg"), 0,0, Layer.PLAYER ) );
        return e;
    }
    
}
