package com.olhcim.potato;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.olhcim.potato.components.Renderable;
import com.olhcim.potato.systems.PlayerInput;
import com.olhcim.potato.util.EntityFactory;
import com.olhcim.potato.util.FileUtil;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Entity player;
        Engine engine;
	
	@Override
	public void create () {
            
            engine = new Engine();
            
            player = EntityFactory.createPlayer(0, 0);
            engine.addEntity(player);
            engine.addSystem( new PlayerInput() );

            batch = new SpriteBatch();
	}

        long oldTime = System.nanoTime();
        long passedTime = 0;
        
	@Override
	public void render () {
            
            long time = System.nanoTime();
            passedTime = time - oldTime;
            oldTime = time;
            
            engine.update( (float) (passedTime / 1000000000.0f) );
            
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                
		batch.begin();
		player.getComponent(Renderable.class).sprite.draw(batch);
		batch.end();
	}
}
