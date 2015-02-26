/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olhcim.potato.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.olhcim.potato.components.Renderable;
import com.olhcim.potato.components.Velocity;

/**
 *
 * @author Nathan
 */
public class Movement extends IteratingSystem {

    private ComponentMapper<Renderable> rm = ComponentMapper.getFor(Renderable.class);
    private ComponentMapper<Velocity> vm = ComponentMapper.getFor(Velocity.class);

    public Movement() {
        super(Family.getFor(Renderable.class, Velocity.class));
    }

    @Override
    public void processEntity(Entity entity, float deltaTime) {
        Renderable r = rm.get(entity);
        Velocity v = vm.get(entity);
        
        r.prex = r.x;
        r.prey = r.y;
        r.x += v.velX * deltaTime;
        r.y += v.velY * deltaTime;
        
        v.velX -= v.velX*v.friction*deltaTime;
        v.velY -= v.velY*v.friction*deltaTime;
    }
}
