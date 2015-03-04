
package com.olhcim.potato.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.olhcim.potato.Main;
import com.olhcim.potato.components.DistExpire;
import com.olhcim.potato.components.Position;
import com.olhcim.potato.components.TimeExpire;

/**
 *
 * @author Nathan
 */
public class DistExpiry extends IteratingSystem {
    
    private ComponentMapper<DistExpire> dm = ComponentMapper.getFor(DistExpire.class);
    private ComponentMapper<Position> pm = ComponentMapper.getFor(Position.class);
    
    public DistExpiry() {
        super(Family.getFor(DistExpire.class, Position.class));
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        DistExpire dist = dm.get(entity);
        Position pos = pm.get(entity);
        
        float distance = (float)Math.sqrt((dist.startx - pos.x) * (dist.startx - pos.x) + (dist.starty - pos.y) * (dist.starty - pos.y));
        
        if(distance >= dist.dist)
        {
            Main.screenGame.engine.removeEntity(entity);
        }
    }
}
