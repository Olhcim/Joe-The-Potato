
package com.olhcim.joe_the_potato.sprites;

import java.awt.Graphics;


public interface GraphicsComponent {
	
	public int getWidth();

	public int getHeight();
	
	public void draw(Graphics g, int x, int y);
        
	public void drawFromCenter(Graphics g, int x, int y);
}