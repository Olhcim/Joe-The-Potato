
package com.olhcim.potato.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.olhcim.potato.components.Bounds;
import com.olhcim.potato.components.Collide;
import com.olhcim.potato.components.Position;
import com.olhcim.potato.components.Velocity;

/**
 *
 * @author Nathan
 */
public class Bounding extends IteratingSystem {

    private ComponentMapper<Position> pm = ComponentMapper.getFor(Position.class);
    private ComponentMapper<Velocity> vm = ComponentMapper.getFor(Velocity.class);
    private ComponentMapper<Collide> cm = ComponentMapper.getFor(Collide.class);
    private ComponentMapper<Bounds> bm = ComponentMapper.getFor(Bounds.class);
    
    public Bounding() {
        super(Family.getFor(Velocity.class, Collide.class, Bounds.class));
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        Position pos = pm.get(entity);
        Velocity vel = vm.get(entity);
        Collide col = cm.get(entity);
        Bounds bou = bm.get(entity);
        
        if ( pos.x + col.radius >= bou.maxX || pos.x - col.radius <= bou.minX)
        {
            vel.velX *= -1;
        }
        
        if ( pos.y + col.radius >= bou.maxY || pos.y - col.radius <= bou.minY)
        {
            vel.velX *= -1;
        }
    }
    
}
