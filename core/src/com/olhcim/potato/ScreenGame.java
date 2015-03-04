
package com.olhcim.potato;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.olhcim.potato.components.Position;
import com.olhcim.potato.components.Renderable;
import com.olhcim.potato.systems.*;
import com.olhcim.potato.systems.DistExpiry;
import com.olhcim.potato.systems.Movement;
import com.olhcim.potato.systems.PlayerInput;
import com.olhcim.potato.systems.TimeExpiry;
import com.olhcim.potato.util.EntityFactory;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;

/**
 *
 * @author Nathan
 */
public class ScreenGame extends MyGameScreen {

    public static final int ID = 2;
    
    public Entity player;
    public final Engine engine = new Engine();;
    
    @Override
    public void initialise(GameContainer gc) {
        player = EntityFactory.createPlayer(0, 0);
        
        engine.addSystem( new PlayerInput(player) );
        engine.addSystem( new Bounding() );
        engine.addSystem( new Movement() );
        engine.addSystem( new DistExpiry() );
        engine.addSystem( new TimeExpiry() );
        
        
        engine.addEntity(player);
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> sm, float f) {
            engine.update( f );
    }

    @Override
    public void interpolate(GameContainer gc, float f) {
        ImmutableArray<Entity> entities = engine.getEntitiesFor( Family.getFor(Position.class, Renderable.class) );
        
        for (int i = 0; i < entities.size(); i++)
        {
            Position p = entities.get(i).getComponent(Position.class);
            Renderable r = entities.get(i).getComponent(Renderable.class);
            r.sprite.setPosition( (p.x*f + p.prex*(1-f)), (p.y*f + p.prey*(1-f)) );
        }
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) {
        ImmutableArray<Entity> entities = engine.getEntitiesFor( Family.getFor(Position.class, Renderable.class) );
        
        for (int i = 0; i < entities.size(); i++)
        {
            Sprite s = entities.get(i).getComponent(Renderable.class).sprite;
            grphcs.drawSprite(s);
        }
    }

    @Override
    public int getId() { return ID; }
}
