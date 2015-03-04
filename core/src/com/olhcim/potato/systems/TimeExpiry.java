
package com.olhcim.potato.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.olhcim.potato.Main;
import com.olhcim.potato.components.TimeExpire;

/**
 *
 * @author Nathan
 */
public class TimeExpiry extends IteratingSystem {
    
    private ComponentMapper<TimeExpire> tm = ComponentMapper.getFor(TimeExpire.class);
    
    public TimeExpiry() {
        super(Family.getFor(TimeExpire.class));
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TimeExpire time = tm.get(entity);
        
        time.progress += deltaTime;
        
        if(time.progress >= time.delay)
        {
            Main.screenGame.engine.removeEntity(entity);
        }
    }
}
