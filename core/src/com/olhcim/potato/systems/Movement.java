package com.olhcim.potato.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.olhcim.potato.components.Position;
import com.olhcim.potato.components.Velocity;

/**
 *
 * @author Nathan
 */
public class Movement extends IteratingSystem {

    private ComponentMapper<Velocity> vm = ComponentMapper.getFor(Velocity.class);
    private ComponentMapper<Position> pm = ComponentMapper.getFor(Position.class);

    public Movement() {
        super(Family.getFor(Position.class, Velocity.class));
    }

    @Override
    public void processEntity(Entity entity, float deltaTime) {
        Position p = pm.get(entity);
        Velocity v = vm.get(entity);

        p.prex = p.x;
        p.prey = p.y;
        p.x += v.velX * deltaTime;
        p.y += v.velY * deltaTime;

        v.velX -= v.velX * v.friction * deltaTime;
        v.velY -= v.velY * v.friction * deltaTime;
    }
}
