package com.olhcim.potato;

import org.mini2Dx.core.game.ScreenBasedGame;

public class Main extends ScreenBasedGame {

        long oldTime = System.nanoTime();
        long passedTime = 0;


    @Override
    public int getInitialScreenId() {
        return ScreenGame.ID;
    }

    @Override
    public void initialise() {
        System.out.println("initialised");
        this.addScreen(new ScreenGame());
    }
}
