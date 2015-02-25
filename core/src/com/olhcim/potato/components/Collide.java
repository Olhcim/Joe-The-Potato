
package com.olhcim.potato.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author Nathan
 */
public class Collide extends Component {
    public float radius;
    
    public Collide(float radius)
    {
        this.radius = radius;
    }
}
