
package com.olhcim.potato.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class FileUtil {
    
    private static final HashMap<String, Texture> textures = new HashMap<String, Texture>();
    
    
    public static Sprite loadSprite(String name)
    {
        return loadSprite(name, "png");
    }
    
    public static Sprite loadSprite(String name, String ext)
    {
        Texture texture = loadTexture(name, ext);
        return new Sprite(texture);
    }
    
    public static Sprite loadCenteredSprite(String name)
    {
        return loadCenteredSprite(name, "png");
    }

    public static Sprite loadCenteredSprite(String name, String ext)
    {
        Texture texture = loadTexture(name, ext);
        Sprite sprite = new Sprite(texture);
        sprite.setCenter(sprite.getWidth()/2, sprite.getHeight()/2);
        sprite.setOriginCenter();
        return sprite;
    }
    
    public static Texture loadTexture(String name)
    {
        return loadTexture(name, "png");
    }
    
    public static Texture loadTexture(String name, String ext)
    {
        if (!textures.containsKey(name))
        {
            Texture texture = new Texture(Gdx.files.internal(name + "." + ext));
            textures.put(name, texture);
        }
        
        return textures.get(name);
    }
    
    
    
    
    
    
    
    
//    private static final HashMap<String, TextureRegion[]> textureRegions = new HashMap<String, TextureRegion[]>();
//    
//    public static Animation loadAnimation(String name, int numFrames, float time, Animation.PlayMode mode)
//    {
//        TextureRegion[] frames = loadTextureRegion(name, numFrames);
//        Animation a = new Animation(time, frames);
//        a.setPlayMode(mode);
//        return a;
//    }
//    
//    public static TextureRegion[] loadTextureRegion(String name, int num)
//    {
//        if(!textureRegions.containsKey(name))
//        {
//            Texture texture = loadTexture(name);
//            TextureRegion[] frames = TextureRegion.split(texture, texture.getWidth()/num, 1)[0];
//            textureRegions.put(name, frames);
//        }
//        
//        return textureRegions.get(name);
//    }
    
    
}
