
package com.olhcim.potato;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.olhcim.potato.components.Renderable;
import com.olhcim.potato.systems.Movement;
import com.olhcim.potato.systems.PlayerInput;
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
    
    SpriteBatch batch;
    Entity player;
    Engine engine;
    
    @Override
    public void initialise(GameContainer gc) {
        engine = new Engine();
            
        player = EntityFactory.createPlayer(0, 0);
        engine.addEntity(player);
        engine.addSystem( new PlayerInput() );
        engine.addSystem( new Movement() );

        batch = new SpriteBatch();
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> sm, float f) {
            engine.update( f );
    }

    @Override
    public void interpolate(GameContainer gc, float f) {
        ImmutableArray<Entity> entities = engine.getEntitiesFor( Family.getFor(Renderable.class) );
        
        for (int i = 0; i < entities.size(); i++)
        {
            Renderable r = entities.get(i).getComponent(Renderable.class);
            r.sprite.setPosition( (r.x*f + r.prex*(1-f)), (r.y*f + r.prey*(1-f)) );
        }
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) {
        ImmutableArray<Entity> entities = engine.getEntitiesFor( Family.getFor(Renderable.class) );
        
        for (int i = 0; i < entities.size(); i++)
        {
            Sprite s = entities.get(i).getComponent(Renderable.class).sprite;
            grphcs.drawSprite(s);
        }
    }

    @Override
    public int getId() { return ID; }
}
