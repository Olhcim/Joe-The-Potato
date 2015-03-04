package com.olhcim.potato.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.olhcim.potato.util.FileUtil;

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

    public Renderable(String fileName, Layer layer)
    {
        this(FileUtil.loadCenteredSprite(fileName), layer);
    }
    
    public Renderable(String fileName, String ext, Layer layer)
    {
        this(FileUtil.loadCenteredSprite(fileName, ext), layer);
    }

    public Renderable(Sprite sprite, Layer layer) {
        this.sprite = sprite;
        this.layer = layer;
    }
}
