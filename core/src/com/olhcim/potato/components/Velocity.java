
package com.olhcim.potato.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author Nathan
 */
public class Velocity extends Component {
    
    public float velX;
    public float velY;
    public float friction;
    
    public Velocity(float velX, float velY)
    {
        this(velX, velY, 2f);
    }
    
    public Velocity(float velX, float velY, float friction)
    {
        this.friction = friction;
        this.velX = velX;
        this.velY = velY;
    }
}
