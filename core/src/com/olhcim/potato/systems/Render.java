/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olhcim.potato.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.olhcim.potato.components.Position;
import com.olhcim.potato.components.Renderable;


public class Render extends IteratingSystem {

    public Render() {
        super(Family.getFor(Renderable.class, Position.class));
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
//        SpriteBatch batch = new SpriteBatch();
//                
//        batch.begin();
//        entity.getComponent(Renderable.class).sprite.draw(batch);
//        batch.end();
    }
    
}
