
package com.olhcim.joe_the_potato;

import com.olhcim.joe_the_potato.sprites.ResourceLoader;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        double scale = 3;
        Frame frame = new Frame((int)(480), (int)(270), scale);
        frame.setVisible(true);
        
        ScreenHandler.init();
        
        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {ScreenHandler.currentScreen.keyTyped(e);}

            @Override
            public void keyPressed(KeyEvent e) {ScreenHandler.currentScreen.keyPressed(e);}

            @Override
            public void keyReleased(KeyEvent e) {ScreenHandler.currentScreen.keyReleased(e);}
        });
        
        Timer timer = new Timer( 1000/30, (ActionEvent e) -> {
            ScreenHandler.render(frame.getCanvas());
            ScreenHandler.Update();
            frame.repaint();
        } );
        
        timer.start();
    }
    
}
