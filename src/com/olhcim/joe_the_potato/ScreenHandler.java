
package com.olhcim.joe_the_potato;

import com.olhcim.joe_the_potato.screens.Screen;
import com.olhcim.joe_the_potato.screens.Screen_Game;
import java.awt.Graphics2D;

public class ScreenHandler {
    
    public static Screen_Game screenGame;
    
    public static Screen currentScreen;
    
    public static void init() {
        screenGame = new Screen_Game();
        currentScreen = screenGame;
    }
    
    public static void Update()
    {
        currentScreen = currentScreen.updateScreen();
    }
    
    public static void render(Canvas canvas)
    {
        Graphics2D g = canvas.getImageGraphics();
        int tx = (int) ((canvas.getImageWidth() - currentScreen.getWidth()) / 2.0);
        int ty = (int) ((canvas.getImageHeight() - currentScreen.getHeight()) / 2.0);
        g.translate(tx, ty);
        currentScreen.draw(g, canvas.getWidth(), canvas.getHeight());
    }
    
    
}
