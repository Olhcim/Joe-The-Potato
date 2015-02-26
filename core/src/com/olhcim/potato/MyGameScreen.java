
package com.olhcim.potato;

import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.Transition;

public abstract class MyGameScreen implements GameScreen {

    @Override
    public void preTransitionIn(Transition trnstn) {}

    @Override
    public void postTransitionIn(Transition trnstn) {}

    @Override
    public void preTransitionOut(Transition trnstn) {}

    @Override
    public void postTransitionOut(Transition trnstn) {}
}
