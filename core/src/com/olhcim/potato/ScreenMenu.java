
package com.olhcim.potato;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.olhcim.potato.components.Renderable;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;

/**
 *
 * @author Nathan
 */
public class ScreenMenu extends MyGameScreen {

    public static final int ID = 1;
    
    @Override
    public void initialise(GameContainer gc) {}

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> sm, float f) {}

    @Override
    public void interpolate(GameContainer gc, float f) {}

    @Override
    public void render(GameContainer gc, Graphics grphcs) {
    }

    @Override
    public int getId() { return ID; }
}
