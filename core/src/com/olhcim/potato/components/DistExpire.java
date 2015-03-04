
package com.olhcim.potato.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author Nathan
 */
public class DistExpire extends Component {
    
    public float startx, starty, dist;
    
    public DistExpire(float startx, float starty, float dist)
    {
        this.startx = startx;
        this.starty = starty;
        this.dist = dist;
    }
}
