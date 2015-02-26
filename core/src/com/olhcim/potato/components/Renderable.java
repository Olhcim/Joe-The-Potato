
package com.olhcim.potato.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author Nathan
 */
public class Renderable extends Component {
    
	public enum Layer {
                DEFAULT,
		BACKGROUND,
		OBJECTS,
		ENEMIES,
		PLAYER,
		PARTICLES;
		
		public int getLayerId() {
			return ordinal();
		}
	}
	
	public Sprite sprite;
        public Layer layer;
        public float x,y,prex,prey;
        
    public Renderable(Sprite sprite, float x, float y, Layer layer)
    {
        this.x = x;
        this.y = y;
        this.prex = x;
        this.prey = y;
        sprite.setPosition(x, y);
        this.sprite = sprite;
        this.layer = layer;
    }
}
