
package com.olhcim.potato.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author Nathan
 */
public class Velocity extends Component {
    
    public float velX;
    public float velY;
    
    public Velocity(float velX, float velY)
    {
        this.velX = velX;
        this.velY = velY;
    }
}
